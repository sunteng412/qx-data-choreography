package com.linqingxuan.datachoreography.core.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务异常
 * @author     : longchuan
 * @date       : 2021/10/9 5:29 下午
 * @description:
 * @version    :
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -5939007908088641474L;

    private String code;

    private String msg;

    public BizException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BizException( String msg,Throwable cause) {
        super(msg,cause);
        this.code = code;
        this.msg = msg;
    }

    public BizException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
