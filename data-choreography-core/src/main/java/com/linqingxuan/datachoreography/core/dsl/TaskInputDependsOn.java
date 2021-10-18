package com.linqingxuan.datachoreography.core.dsl;


import lombok.Data;

import java.io.Serializable;

/**
   *  输入依赖项
   * @description:
   * @author : MrFox
   * @date : 2021/10/18 23:00
  */
@Data
public class TaskInputDependsOn implements Serializable {

    private static final long serialVersionUID = -5795089018013798231L;

    /**
     * 字段名
     * */
    private String fieldName;

    /**
     * 依赖任务别名
     * */
    private String dependsOnTask;

    /**
     * 依赖的字段 ognl
     * */
    private String dependsOnField;
}
