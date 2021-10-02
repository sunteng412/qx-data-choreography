package com.linqingxuan.datachoreography.core.dsl;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回类型判断-没有则代表必定为成功，结果即为响应的dataField根
 * @author     : longchuan
 * @date       : 2021/10/2 3:59 下午
 * @description:
 * @version    :
 */
@Data
public class RetGenericDefinition implements Serializable {

    private static final long serialVersionUID = -5795089018013798231L;

    /**
     * ognl表达式判断返回json是否正确
     * */
    private String successDetermination;

    /**
     * 返回数据结果映射字段
     * */
    private String dataField;

}
