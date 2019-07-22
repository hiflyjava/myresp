package com.pg.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pg.bean.Hr;
import com.pg.bean.RespBean;
import com.pg.common.utils.HrUtils;
import com.pg.common.utils.SessionUtil;
import com.pg.service.HrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 *  create by harden  2019-03-25
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    HrService hrService;
    @Autowired
    CustomMetadataSource metadataSource;
    @Autowired
    UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    AuthenticationAccessDeniedHandler deniedHandler;
    @Autowired
    SessionRegistry sessionRegistry;


    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
    // key为sessionId，value为HttpSession，使用static，定义静态变量，使之程序运行时，一直存在内存中。
    // 保存所有已经登录用户的会话（每个浏览器一个会话）
    public static HashMap<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();




    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html", "/static/**", "/login_p", "/favicon.ico","/smartaccess/login");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {




        //控制接口的权限
        http.authorizeRequests().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setSecurityMetadataSource(metadataSource);
                o.setAccessDecisionManager(urlAccessDecisionManager);
                return o;
            }
        });


        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin()
                .and().csrf().disable();

        http.authorizeRequests().anyRequest().authenticated().and().logout().logoutUrl("/logout").logoutSuccessHandler(new LogoutSuccessHandler() {
            @Override
            public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                response.setContentType("application/json;charset=utf-8");
                RespBean respBean = RespBean.ok("logout success!");
                ObjectMapper om = new ObjectMapper();
                PrintWriter out = response.getWriter();
                out.write(om.writeValueAsString(respBean));
                out.flush();
                out.close();
            }
        });
        http.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }


    @Bean
    public SessionRegistry getSessionRegistry(){
        SessionRegistry sessionRegistry=new SessionRegistryImpl();
        return sessionRegistry;
    }



    //登录成功的操作
    @Bean
    CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        //filter.setSessionAuthenticationStrategy(new ConcurrentSessionControlAuthenticationStrategy(sessionRegistry));
        filter.setAuthenticationSuccessHandler((req, resp, authentication) -> {

            //校验是当前用户已经登录，如果已经登录，将之前登录的用户剔除，
            WebSecurityConfig.onAuthenticationSuccess(req, resp, authentication,sessionRegistry);

            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();
            RespBean respBean = RespBean.ok("login success!", HrUtils.getCurrentHr());

            //sessionRegistry.registerNewSession(req.getSession().getId(),authentication.getPrincipal());
            out.write(new ObjectMapper().writeValueAsString(respBean));
            out.flush();
            out.close();
        });
        filter.setAuthenticationFailureHandler((req, resp, e) -> {
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();
            RespBean respBean = RespBean.error("Login Failed");
            out.write(new ObjectMapper().writeValueAsString(respBean));
            out.flush();
            out.close();
        });
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

    /**
     * 密码加密
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



    public  static void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                Authentication authentication,  SessionRegistry sessionRegistry) throws ServletException, IOException {

        // 1.登录认证成功后，获取用户名
        SecurityContext sc = SecurityContextHolder.getContext();
        String currentuser = ((Hr) sc.getAuthentication().getPrincipal()).getUsername();
        logger.info("当前登录用户：" + currentuser);


        // 2.先判断用户是否重复登录
        Iterator<Map.Entry<String, HttpSession>> iterator = sessionMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, HttpSession> entry = iterator.next();
            HttpSession session = entry.getValue();
            // 2.1 判断session中所包含的用户名称是否有当前登录用户
            String username = SessionUtil.getUserName(session);
            if (currentuser.equals(username)) {

                logger.info("用户：" + currentuser + "已经在其它地方登录过，将踢除！");
                SessionUtil.expireSession(session);
                logger.info("删除的会话："+entry.getKey());
                // 2.2 从sessionMap中踢除会话
                iterator.remove();
                // 2.3 从sessionRegistry中踢除会话
                sessionRegistry.removeSessionInformation(session.getId());
            }
        }


        // 3.将当前session保存到sessionMap中
        logger.info("将当前会话:" + request.getSession().getId() + "，保存到sessionMap");
        sessionMap.put(request.getSession().getId(), request.getSession());
        for (Map.Entry<String, HttpSession> entry : sessionMap.entrySet()) {
            logger.info("显示已经保存的sessionMap:Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        // 4.打印所有认证通过的用户（包含重复登录的,不过上面已经踢除了）
        List<Object> principals = sessionRegistry.getAllPrincipals();
        List<String> usersNamesList = new ArrayList<String>();
        for (Object principal: principals) {
            if (principal instanceof Hr) {
                usersNamesList.add(((Hr) principal).getUsername());
            }
        }
        logger.info("已经认证通过的用户数:"+usersNamesList.size()+"，     已经认证通过用户："+usersNamesList.toString());


    }




}