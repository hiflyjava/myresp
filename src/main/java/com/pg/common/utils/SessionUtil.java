package com.pg.common.utils;

import com.pg.bean.Hr;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/6/25 14:15
 * @Description:
 */
public class SessionUtil {

    private static SecurityContext attribute;

    /**
     * 根据当前session获取当前登录用户对象
     * @param session
     * @return guser
     */
    public static Hr getUser(HttpSession session) {
        try {
            attribute = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
            Hr principal = (Hr) attribute.getAuthentication().getPrincipal();
            return principal;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 根据当前session获取当前登录用户ID
     * @param session
     * @return guser
     */
    public static Integer getUserId(HttpSession session) {
        try {
            attribute = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
            Hr principal = (Hr) attribute.getAuthentication().getPrincipal();
            return  Integer.parseInt( principal.getId()+"");
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 根据session获取用户名称
     * @param session
     * @return void
     */
    public static String getUserName(HttpSession session) {
        try {
            attribute = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
            Hr principal = (Hr) attribute.getAuthentication().getPrincipal();
            return principal.getUsername();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据session获取count
     * session中包含一个count键默认为null，可以用来统计登录次数
     * @param session
     * @return void
     */
    public static void count(HttpSession session) {
        ServletContext context = session.getServletContext();

        System.out.println("sessionid:"+session.getId()+",的count是："+context.getAttribute("count"));
    }


    /**
     * 辨别用户是否已经登录，如果已经登录就不能登录了。
     *
     * @param request
     * @param sessionRegistry
     * @param loginedUser
     */
    public static void deleteSameUser(HttpServletRequest request, SessionRegistry sessionRegistry, Hr loginedUser) {
        SecurityContext sc = (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        List<SessionInformation> sessionsInfo;
        sessionsInfo = sessionRegistry.getAllSessions(sc.getAuthentication().getPrincipal(), true);
        String currentSessionId;
        if (null != sessionsInfo && sessionsInfo.size() == 0) {
            sessionRegistry.registerNewSession(request.getSession().getId(), sc.getAuthentication().getPrincipal());
            sessionsInfo = sessionRegistry.getAllSessions(sc.getAuthentication().getPrincipal(), false);
        }
        currentSessionId = sessionsInfo.get(0).getSessionId();
        List<Object> o = sessionRegistry.getAllPrincipals();
        for (Object principal : o) {
            if (principal instanceof Hr && (loginedUser.getUsername().equals(((Hr) principal).getUsername()))) {
                List<SessionInformation> oldSessionsInfo = sessionRegistry.getAllSessions(principal, false);
                if (null != oldSessionsInfo && oldSessionsInfo.size() > 0 && !oldSessionsInfo.get(0).getSessionId().equals(currentSessionId)) {
                    for (SessionInformation sessionInformation : sessionsInfo) {
                        //当前session失效
                        sessionInformation.expireNow();
                        sc.setAuthentication(null);
                        sessionRegistry.removeSessionInformation(currentSessionId);
                        //throw new GeneralServerExistException(ErrorMessage.ALONG_LOGIN_ERROTR.toString());
                    }
                }
            }
        }
    }

    /**
     * 会话销毁(剔除前一个用户)
     * @param , SysMessageService sysMessageService
     */
    public static void expireSession(HttpSession session) {
        session.invalidate();
    }


    /**
     * 剔除前一个用户
     *
     * @param request
     * @param sessionRegistry
     * @param loginedUser
     * @param , SysMessageService sysMessageService
     */
    public static void dropPreviousUser2(HttpServletRequest request, SessionRegistry sessionRegistry, Hr loginedUser) {
        List<SessionInformation> sessionsInfo = null;
        //登录以后session里才会加入键名为"SPRING_SECURITY_CONTEXT"的字段
        SecurityContext sc = (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");

        if(sc!=null) {
            System.out.println("!!!!!!!!!!!!"+sc.getAuthentication().getPrincipal().toString());
            //获取当前登录用户的会话信息集合
            sessionsInfo = sessionRegistry.getAllSessions(sc.getAuthentication().getPrincipal(), false);
            if (sessionsInfo.size() > 0) {
                //当前会话ID
                String  currentSessionId = sessionsInfo.get(0).getSessionId();
                //获取所有已经登录的用户
                List<Object> o = sessionRegistry.getAllPrincipals();
                for (Object principal : o) {
                    //当登录用户的名字和已经登录用户的名字相同，也就是登录用户已经登录过了。
                    if (principal instanceof Hr && (loginedUser.getUsername().equals(((Hr) principal).getUsername()))) {
                        //获取已经登录用户的会话信息集合
                        List<SessionInformation> oldSessionsInfo = sessionRegistry.getAllSessions(principal, false);
                        //如果会话信息不为空且会话信息的ID不等于当前会话ID
                        if (null != oldSessionsInfo && oldSessionsInfo.size() > 0 && !oldSessionsInfo.get(0).getSessionId().equals(currentSessionId)) {
                            //遍历已经登录用户的会话信息，并设置过期，即删除session
                            for (SessionInformation sessionInformation : oldSessionsInfo) {
                                //旧用户的session失效
                                //send message
                                //sysMessageService.sendMessage(((User) principal).getUsername(), new SysMessage(null, Consts.NOTIFICATION_TYPE_HADLOGIN_CONTENT, 5, Consts.NOTIFICATION_ACCEPT_TYPE_HADLOGIN));
                                sessionInformation.expireNow();
                            }
                        }
                    }
                }
            }
        }

    }

    /**
     * session 失效
     *
     * @param request
     * @param sessionRegistry
     */
    public static void expireSession(HttpServletRequest request, Hr user, SessionRegistry sessionRegistry) {
        List<SessionInformation> sessionsInfo = null;
        if (null != user) {
            List<Object> o = sessionRegistry.getAllPrincipals();
            for (Object principal : o) {
                if (principal instanceof Hr && (user.getUsername().equals(((Hr) principal).getUsername()))) {
                    sessionsInfo = sessionRegistry.getAllSessions(principal, false);
                }
            }
        } else if (null != request) {
            SecurityContext sc = (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
            if (null != sc.getAuthentication().getPrincipal()) {
                sessionsInfo = sessionRegistry.getAllSessions(sc.getAuthentication().getPrincipal(), false);
                sc.setAuthentication(null);
            }
        }
        if (null != sessionsInfo && sessionsInfo.size() > 0) {
            for (SessionInformation sessionInformation : sessionsInfo) {
                //当前session失效
                sessionInformation.expireNow();
                sessionRegistry.removeSessionInformation(sessionInformation.getSessionId());
            }
        }
    }

    public void showsession(HttpServletRequest request) {
        //获取session
        HttpSession session   =   request.getSession();
        // 获取session中所有的键值
        Enumeration<String> attrs = session.getAttributeNames();
        // 遍历attrs中的
        while(attrs.hasMoreElements()){
            // 获取session键值
            String name = attrs.nextElement().toString();
            // 根据键值取session中的值
            Object vakue = session.getAttribute(name);
            // 打印结果
            System.out.println("--sessionID"+session.getId());
            System.out.println("--名字：" + name +"-----\n");
            System.out.println("--值：" + vakue +"--------\n");
        }

    }

}
