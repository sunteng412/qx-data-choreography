package com.linqingxuan.datachoreography.core.dsl.config;


import lombok.Data;

import java.util.Map;

/**
   * 数据库配置
   * @description:
   * @author : MrFox
   * @date : 2021/10/7 22:48
  */
@Data
public class DataConfig {

     /**
      * 数据源配置
      * */
    private Map<String, Object> dataSourceProps;

    /**
     * 数据配置
     * */
    private Map<String, Object> dataProps;



}
