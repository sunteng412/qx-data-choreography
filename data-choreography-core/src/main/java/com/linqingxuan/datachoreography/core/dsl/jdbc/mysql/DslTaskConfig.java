package com.linqingxuan.datachoreography.core.dsl.jdbc.mysql;

import lombok.Data;

import java.io.Serializable;


/**
   * 数据库任务对应实体
   * @description:
   * @author : MrFox
   * @date : 2021/10/13 23:35
  */
@Data
public class DslTaskConfig implements Serializable {

    private static final long serialVersionUID = 3108603214724709456L;



    private Long id;

    private Long dslId;

    private String taskAlias;

    private String taskDesc;

    private String retGenericDefinition;

    private String taskParams;

    private String taskType;

    private Integer location;

    private String inputDependsOn;

    private Long timeout;

    private Integer maxRetryTimes;

}
