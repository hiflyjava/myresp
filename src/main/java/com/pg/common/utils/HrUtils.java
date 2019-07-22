package com.pg.common.utils;

import com.pg.bean.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by pg on 2017/12/30.
 */
public class HrUtils {
    public static Hr getCurrentHr() {
    	//登录直接进来，验证账号密码，并且存入auth中
        return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
