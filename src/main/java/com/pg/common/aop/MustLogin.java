package com.pg.common.aop;

import java.lang.annotation.*;

/**
 * @Auther: admin
 * @Date: 2019/4/30 15:26
 * @Description:
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MustLogin {
}
