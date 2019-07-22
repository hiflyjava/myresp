package com.pg.common.aop;

import com.pg.bean.Hr;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: admin
 * @Date: 2019/4/30 15:32
 * @Description:
 */
@Component
@Aspect
public class MustLoginAop {


    @Autowired
    private HttpServletRequest request;

   // @Around("execution(* com.pg.controller.hotel..*.*(..)) && @annotation(com.pg.common.aop.MustLogin)")
    public String mustLogin(){
        Hr hr =new Hr();

        if(hr==null){
            String returnUrl=request.getScheme()+"://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath()+request.getRequestURI();
            //获得参数，需要为get请求
            String params = request.getQueryString();
            returnUrl=returnUrl+"?"+params;
            returnUrl.replace("&","*");
            return "redirect:http://localhost:8082/test";
        }else {
            return  "";//放行
        }

    }

}
