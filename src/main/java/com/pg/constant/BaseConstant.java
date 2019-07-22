package com.pg.constant;

import java.io.Serializable;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @Description : 返回码code
 * ---------------------------------
 * @Author : HarDen
 * @Date : Create in 2019/03/25 15:25
 */

public class BaseConstant implements Serializable {

    /**
     * 是
     */
    public static final String YES = "1";
    /**
     * 否
     */
    public static final String NO = "0";

    /**
     * 删除标记(0:正常, 1:删除)
     */
    public static final String DEL_FLAG_0 = "0";
    /**
     * 删除标记(0:正常, 1:删除)
     */
    public static final String DEL_FLAG_1 = "1";



    /** --------------------------------- */
    /** ------ 返回码定义 -------- */
    /** --------------------------------- */

    /**
     * 成功
     */
    public static final String E_000 = "000";
    public static final String MSG_000 = "操作成功";
    /**
     * 失败
     */
    public static final String E_001 = "001";
    public static final String MSG_001 = "操作失败";
    /**
     * 参数格式错误
     */
    public static final String E_002 = "002";
    /**
     * 缺少参数
     */
    public static final String E_003 = "003";
    /**
     * 用户session失效
     */
    public static final String E_004 = "004";
    /**
     * 不支持的接口
     */
    public static final String E_005 = "005";
    /**
     * 其他消息
     */
    public static final String E_006 = "006";
    /** */
    public static final String E_101 = "101";
    /**
     * 账户禁止登录
     */
    public static final String E_102 = "102";
    /**
     * 登录失败(用户名不存在)
     */
    public static final String E_103 = "103";
    /**
     * 登录失败(密码错误)
     */
    public static final String E_104 = "104";
    /**
     * sign签名不正确
     */
    public static final String E_105 = "105";
    /**
     * 系统内部异常
     */
    public static final String E_107 = "107";
    /** 账户不允许在App登录 */
    /**
     * 账户不允许在App登录
     */
    public static final String E_108 = "108";
    public static final String E_501 = "501";

}
