package com.linqingxuan.datachoreography.dubbo.dsl;

import lombok.Data;

import java.io.Serializable;

/**
 * 输入参数类型定义
 * @author     : longchuan
 * @date       : 2021/10/2 4:10 下午
 * @description:
 * @version    :
 */
@Data
public class InputDefinition implements Serializable {

    private static final long serialVersionUID = -5795089018013798231L;

    /**
     * 字段名
     * */
    private String fieldName;

    /**
     * 字段类名
     * */
    private String className;

    /**
     * 所在第N个
     * */
    private String location;

    /**
     * 依赖字段
     * */
    private String dependsOn;
}
