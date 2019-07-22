package com.pg.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: admin
 * @Date: 2019/5/9 18:49
 * @Description:
 */
//@Component
    //extends LoginUrlAuthenticationEntryPoint
  //  @Component
public class AjaxSessionInformationExpiredStrategy  implements HandlerInterceptor {



    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
       // logger.info("************BaseInterceptor preHandle executed**********");
        System.out.println("===>>>>>>>自定义的拦截器");
        String reqUrl = request.getServletPath();
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        if((!reqUrl.contains("/login")) && authentication ==null){
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(403);
            return false;
        }

        return true;

      //  boolean isLogin = AuthorityUtils.isLogin(request);
      /*  if((!reqUrl.contains("/checkCode.do") && !reqUrl.contains("/login.do")) && !isLogin){
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(403);
            return false;
        }*/


    }

    /**
     * 在controller执行之后的DispatcherServlet之后执行
     * */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView mv)
            throws Exception {
      //  logger.info("************BaseInterceptor postHandle executed**********");
    }

    /**
     * 在页面渲染完成返回给客户端之前执行
     * */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception e)
            throws Exception {
       // logger.info("************BaseInterceptor afterCompletion executed**********");
    }


}
