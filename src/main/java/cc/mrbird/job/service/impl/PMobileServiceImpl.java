package cc.mrbird.job.service.impl;

import cc.mrbird.common.domain.SendSmsIn;
import cc.mrbird.common.util.CheckPhone;
import cc.mrbird.common.util.MyUserUtiles;
import cc.mrbird.common.util.RespBean;
import cc.mrbird.common.util.SendMsgsUtils;
import cc.mrbird.job.dao.PMobileMapper;
import cc.mrbird.job.dao.PMobileSuccessMapper;
import cc.mrbird.job.domain.PMobile;
import cc.mrbird.job.service.PMobileService;
import cc.mrbird.system.domain.User;
import cc.mrbird.system.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class PMobileServiceImpl implements PMobileService {


    @Autowired
    PMobileMapper mobileMapper;

    @Autowired
    PMobileSuccessMapper successMapper;

    @Autowired
    UserService userService;

    @Value("${sms.accesskey}")
    private String accesskey;

    @Value("${sms.accessSecret}")
    private String accessSecret;

    @Value("${sms.sendUrl}")
    private String sendUrl;

    @Value("${sms.getBalanceUrl}")
    private String getBalanceUrl;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(PMobile record) {
        return 0;
    }

    @Override
    public int insertSelective(PMobile record) {

        return 0;
    }

    @Override
    public PMobile selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(PMobile record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(PMobile record) {
        return 0;
    }

    @Override
    public RespBean insertMobileForeach(List<String> list,String content) throws Exception {
            SendSmsIn sendSmsIn =new SendSmsIn();
            sendSmsIn.setAccesskey(accesskey);
            sendSmsIn.setAccessSecret(accessSecret);
            sendSmsIn.setSendContent(content);
            sendSmsIn.setSign("134043");
            sendSmsIn.setSendUrl(sendUrl);

        List<PMobile> mobiles =new ArrayList<>();//这是所有接收到的手机号

        List<String> realMobiles=new ArrayList<>();
        for(String mobile :list){
            PMobile pMobile =new PMobile();
            if(CheckPhone.isPhone(mobile)){
                realMobiles.add(mobile);
                if(CheckPhone.isChinaMobilePhoneNum(mobile)){
                       pMobile.setType(CheckPhone.CHINA_MOBILE);//移动
                }
                if(CheckPhone.isChinaTelecomPhoneNum(mobile)){
                    pMobile.setType(CheckPhone.CHINA_TELECOM);//电信
                }

                if(CheckPhone.isChinaUnicomPhoneNum(mobile)){
                    pMobile.setType(CheckPhone.CHINA_UNICOM);//联通
                }

                pMobile.setMobile(mobile);
                pMobile.setCreateBy("admin");
                pMobile.setCreateDate(new Date());
                pMobile.setStatus(1);
                pMobile.setUserId(4);
                mobiles.add(pMobile);
            }
        }

         if(realMobiles.size()>1000){
             RespBean respBean =RespBean.build();
             respBean.setStatus(900);
             respBean.setMsg("短信余额不足，请联系管理员充值");
            return respBean;
         }

        if(realMobiles.size()<1000){//如果发送条数小于1000；不扣
            sendSmsIn.setMobiles(realMobiles);
            SendMsgsUtils.sendsms(sendSmsIn);
        }else {//如果发送条数大于1000；扣50%

        }
        mobileMapper.insertMobileForeach(mobiles);
        User user =new User();
        user.setSmsnum(1000-mobiles.size());
        user.setUserId(4l);
        user.setLastLoginTime(new Date());
        userService.updateUserProfile(user);
     return    RespBean.ok("发送成功") ;

    }

    @Override
    public String getBalanceSms() throws IOException {
        SendSmsIn sendSmsIn =new SendSmsIn();
        sendSmsIn.setAccessSecret(accessSecret);
        sendSmsIn.setAccesskey(accesskey);
        sendSmsIn.setGetBalanceUrl(getBalanceUrl);
        SendMsgsUtils.getBalanceSms(sendSmsIn);
        return null;
    }
}
