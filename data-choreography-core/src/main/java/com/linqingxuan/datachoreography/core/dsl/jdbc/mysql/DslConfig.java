package com.linqingxuan.datachoreography.core.dsl.jdbc.mysql;

import lombok.Data;

import java.io.Serializable;


/**
   * 数据库对应实体
   * @description:
   * @author : MrFox
   * @date : 2021/10/13 23:35
  */
@Data
public class DslConfig implements Serializable {

    private static final long serialVersionUID = 3108603214724709456L;


    private Long id;

    private String name;

    private String dslDesc;

    private String outputs;

    private Long timeout;

    private Integer maxRetryTimes;

}
