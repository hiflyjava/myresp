package com.pg.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pg.bean.Menu;
import com.pg.bean.RespBean;
import  com.pg.bean.Role;
import com.pg.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pg on 2017/12/28.
 */
@Component

public class CustomMetadataSource  implements FilterInvocationSecurityMetadataSource  {
    @Autowired
    MenuService menuService;

    @Autowired
    HttpServletResponse response;

    //当前请求的url，所需要的角色集合
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    //这里是请求 url 跟 menu表中的url 比较 getAttributes  这个方法

    /**
     *
     * 该方法每次请求时就会触发
     * 返回的是该请求对应的角色list
     * @param o
     * @return
     */
   @Override
    public Collection<ConfigAttribute> getAttributes(Object o) {

        String requestUrl = ((FilterInvocation) o).getRequestUrl();

       SecurityContext context = SecurityContextHolder.getContext();
       Authentication authentication = context.getAuthentication();
       Object principal = authentication.getPrincipal();
       String s = principal.toString();

       if(s.equals("anonymousUser")){//session 超时
           response.setStatus(HttpServletResponse.SC_REQUEST_TIMEOUT);
           response.setContentType("application/json;charset=UTF-8");
           PrintWriter out = null;
           try {
               out = response.getWriter();
               RespBean error = RespBean.error("session timeout");
               error.setStatus(408);
               out.write(new ObjectMapper().writeValueAsString(error));
               out.flush();
               out.close();
           } catch (IOException e) {
               e.printStackTrace();
           }

           return  SecurityConfig.createList("ROLE_LOGIN");
       }
       //redisTemplate.opsForValue().set();
      //请求的url跟菜单表中的url匹配
       List<Menu> allMenu = menuService.getAllMenu();
        for (Menu menu : allMenu) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl)
                    &&menu.getRoles().size()>0) {
                //当前菜单所对应的角色集合
                List<Role> roles = menu.getRoles();
                int size = roles.size();
                String[] values = new String[size];
                for (int i = 0; i < size; i++) {
                    values[i] = roles.get(i).getName();
                }

                return SecurityConfig.createList(values);
            }
        }

        //没有匹配上的资源，都是登录访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }
    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
