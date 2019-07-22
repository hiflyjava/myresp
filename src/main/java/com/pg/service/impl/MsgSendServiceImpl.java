package com.pg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.pg.bean.*;
import com.pg.common.dto.in.MsgIn;
import com.pg.common.dto.in.MsgPageIn;
import com.pg.common.utils.HrUtils;
import com.pg.common.utils.MyDateUtils;
import com.pg.common.utils.SendEmailUtils;
import com.pg.mapper.*;
import com.pg.service.MsgSendService;
import com.pingenie.remote.LockProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.NestedServletException;

import java.util.Date;
import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/6/21 15:10
 * @Description:
 */

@Service
@Transactional
public class MsgSendServiceImpl implements MsgSendService {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

   /* @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender javaMailSender;*/

    @Value("${email.username}")
    private String fromEmail;
    @Value("${email.host}")
    private String host;
    @Value("${email.port}")
    private Integer port;
    @Value("${email.password}")
    private String password;

    @Autowired
    PgshRoomCustomerMapper roomCustomerMapper;

    @Autowired
    PgMsgLogMapper msgLogMapper;

    @Autowired
    PgEmailLogMapper emailLogMapper;



    @Autowired
    PgshHotelEntityMapper hotelEntityMapper;

    @Override
    public int sendMsg(MsgIn msg) {

        LockProxy lockProxy =new LockProxy();
        String sms ;
                PgshRoomCustomer pgshRoomCustomer = roomCustomerMapper.selectByIdCard(msg.getIdCard());
                if(pgshRoomCustomer ==null){
                    return  -1;
                }

        String MailBody="【"+msg.geteName()+"】 Dear "+pgshRoomCustomer.getName()+"！您的房间号是"+msg.getRoomNbr()
                +",房间密码是:"+msg.getKeyword()+",入住时间为:"+msg.getStartTime()+" - "+msg.getEndTime(); //短信主题
      try {
          String telephone= pgshRoomCustomer.getPhoneType()+ pgshRoomCustomer.getTelephone();
          sms = lockProxy.sendSMS(telephone, MailBody);
          System.out.println(sms);
          return 1;
      }catch (Exception e){
          //System.out.println("zz");
      }finally {
          PgMsgLog pgMsgLog =new PgMsgLog();
          pgMsgLog.setCreateBy(HrUtils.getCurrentHr().getUsername());
          pgMsgLog.setCreateDate(new Date());
          pgMsgLog.setEntityId(msg.getEid());
          pgMsgLog.setRoomNbr(msg.getRoomNbr());
          pgMsgLog.setPhone(pgshRoomCustomer.getPhoneType()+pgshRoomCustomer.getTelephone());
         // String json = new Gson().toJson(msg);
          pgMsgLog.setMsgInfo(MailBody);
          pgMsgLog.setGname(pgshRoomCustomer.getName());
          int i = msgLogMapper.insertSelective(pgMsgLog);
          return  i;
      }
      //  String sms = lockProxy.sendSMS("8618566211852", "Test msg from Harden");
       // String result = lockProxy.sendSMS("8618566211852", "Test 123 sent from PG remote");


    }

    @Override
    public int sendEmail(MsgIn msgIn) throws Exception {

        PgshRoomCustomer pgshRoomCustomer = roomCustomerMapper.selectByIdCard(msgIn.getIdCard());
       // PgshOrder pgshOrder = orderMapper.selectByPrimaryKey(msgIn.getOrderId());
        PgshHotelEntity entity = hotelEntityMapper.selectByPrimaryKey(Long.parseLong(msgIn.getEid() + ""));
        if(entity ==null){
            return  -1;

        }else {
            msgIn.setAddress(entity.getAddress());
        }

        if(pgshRoomCustomer ==null){
            return  -1;
        }else {
            msgIn.setEmail( pgshRoomCustomer.getEmail());
            msgIn.setGuestName(pgshRoomCustomer.getName());

        }

//        if(pgshOrder ==null){
//            return  -1;
//        }else {
//            msgIn.setOrderNo(pgshOrder.getOrderNumber());
//        }

        String SMTPHost="smtp.163.com";
        String Port="25";
        String MailUsername="m13217384321@163.com"; //直接用我的邮件进行发送测试
        String MailPassword="y15675311927"; //密码请勿修改
        long daySub = MyDateUtils.getDaySub(msgIn.getStartTime(), msgIn.getEndTime());
        msgIn.setNights(Integer.parseInt(daySub+""));
        SendEmailUtils.sendEmails(fromEmail,host,port,password,msgIn);
        //将邮箱信息存入数据库
        PgEmailLog pgEmailLog =new PgEmailLog();
        pgEmailLog.setCreateBy(HrUtils.getCurrentHr().getUsername());
        pgEmailLog.setCreateDate(new Date());
        pgEmailLog.setEntityId(msgIn.getEid());
        pgEmailLog.setRoomNbr(msgIn.getRoomNbr());
        pgEmailLog.setEmail(pgshRoomCustomer.getEmail());
        msgIn.setEmail(null);
        msgIn.setAddress(null);
        msgIn.setGuestName(null);
        msgIn.setFlag(null);
        String json = new Gson().toJson(msgIn);
        pgEmailLog.setEmailInfo(json);
        pgEmailLog.setGname(pgshRoomCustomer.getName());
        int i = emailLogMapper.insertSelective(pgEmailLog);
        return i;
    }

    @Override
    public PageInfo<PgEmailLog> getEmailPage(MsgPageIn msgPageIn) {
        PageHelper.startPage(msgPageIn.getCurrentPage(), msgPageIn.getPageSize());
        List<PgEmailLog> emailPage = emailLogMapper.getEmailPage(msgPageIn);
        return new PageInfo<>(emailPage);
    }

    @Override
    public PageInfo<PgMsgLog> getMsgPage(MsgPageIn msgPageIn) {
        PageHelper.startPage(msgPageIn.getCurrentPage(), msgPageIn.getPageSize());
        List<PgMsgLog> msgPage = msgLogMapper.getMsgPage(msgPageIn);
        return new PageInfo<>(msgPage);

    }
}
