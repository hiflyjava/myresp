package cc.mrbird.common.util;

import cc.mrbird.system.domain.User;
import org.apache.shiro.SecurityUtils;

public class MyUserUtiles {


    public static  User getUser(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return  user;
    }


}
