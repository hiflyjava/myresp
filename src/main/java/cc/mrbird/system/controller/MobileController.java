package cc.mrbird.system.controller;



import cc.mrbird.common.util.RespBean;
import cc.mrbird.common.util.SendMsgsUtils;
import cc.mrbird.job.service.PMobileService;
import cc.mrbird.system.utils.ImportExcelUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@RestController
@RequestMapping("/mobile")
public class MobileController {


    private static  final Logger logger = Logger.getLogger(MobileController.class);
   @Autowired
    PMobileService pMobileService;

    /**
     * 批量上传手机号
     * @param file
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/batchAddMobiles")
    @ResponseBody
    public RespBean batchAddMobiles(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request,@RequestParam(value = "content")String content ) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        Set<String> mobiles = new HashSet<>();
        System.out.println(content);
        //excel文件上传
        String path = request.getSession().getServletContext().getRealPath("/");
        String fileName = System.currentTimeMillis() + file.getOriginalFilename();
        try {
            if (!file.isEmpty()) {
                // 这里将上传得到的文件保存指定目录下
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path, fileName));
            }

            InputStream in = null;
            List<List<Object>> listob = null;
            in = file.getInputStream();
            listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
            for (int i = 0; i < listob.size(); i++) {
                List<Object> lo = listob.get(i);
                //TODO 根据excel格式获取指定的参数,还可优化:用正则表达式匹配过滤不符合的参数
                String mobile = String.valueOf(lo.get(0));
                mobiles.add(mobile);
            }

        } catch (Exception e) {
            //TODO 记录完善的日志和异常处理
            logger.error("batchAddMobiles()失败,原因为:" + e.getMessage(), e);
        } finally {
            //处理完后需删除本地文件
            File file2 = new File(path + File.separator + fileName);
            if (file2.exists()) {
                file2.delete();
            }
        }

        //添加判断&业务处理
        if (null != mobiles && mobiles.size() > 0) {
            //TODO 业务逻辑处理
        }

        //返回结果
        result.put("mobiles", mobiles);
        List<String> mobileList=new ArrayList<>();
        mobileList.addAll(mobiles);
        pMobileService.insertMobileForeach(mobileList,content);
        return RespBean.ok("mobiles",mobileList);
    }


    @RequestMapping("/getBalanceSms")
    public String getBalanceSms() throws IOException {

       pMobileService.getBalanceSms();
       return  "";
    }



}
