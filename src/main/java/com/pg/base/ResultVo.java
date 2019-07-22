package com.pg.base;

import com.pg.constant.BaseConstant;

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
 * @Description : 通用返回封装
 * ---------------------------------
 * @Author : Zheng
 * @Date : Create in 2019/03/25 15:25
 */

public class ResultVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 数据
     */
    public Object data;

    /**
     * 返回码
     */
    public String code = BaseConstant.E_000;

    /**
     * 错误描述信息
     */
    public String errorMessage;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setResultVoInfo(String code,String msg){
        this.code = code;
        this.errorMessage = msg;
    }
}
