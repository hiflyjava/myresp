package com.pg.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: admin
 * @Date: 2019/5/9 22:45
 * @Description:
 */
//@Configuration
//extends WebMvcConfigurationSupport
public class Myfilter  {
    private static final Logger logger = LoggerFactory.getLogger(Myfilter.class);


//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        HandlerInterceptor handlerInterceptor = new HandlerInterceptor() {
//            @Override
//            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//                System.out.println("自定义拦截器执行了。。。。。");
//                String reqUrl = request.getServletPath();
//                //boolean isLogin = AuthorityUtils.isLogin(request);
//                SecurityContext context = SecurityContextHolder.getContext();
//                Authentication authentication = context.getAuthentication();
//
//                if((!reqUrl.contains("/login")) && authentication ==null){
//                    response.setContentType("text/html;charset=utf-8");
//                    response.setStatus(403);
//                    return false;
//                }
//
//                return true;
//            }
//        };
//        registry.addInterceptor(handlerInterceptor).addPathPatterns("/**").excludePathPatterns("/index.html","/static/**","/login");
//        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/index.html", "/", "/user/login");
//
//    }

}
