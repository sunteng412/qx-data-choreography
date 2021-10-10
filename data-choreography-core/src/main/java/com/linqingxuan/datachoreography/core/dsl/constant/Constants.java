package com.linqingxuan.datachoreography.core.dsl.constant;


 /**
   * 常用常量
   * @description:
   * @author : MrFox
   * @date : 2021/10/7 22:29
  */
public interface Constants {

     String LINE_SEPARATOR = System.getProperty("line.separator");


     String OS_NAME = System.getProperty("os.name");

     String USER_HOME = System.getProperty("user.home");

     String CHARSET = "UTF-8";


     /**
      * dsl配置表名
      * */
     String DSL_CONFIG_TABLE = "qx_dsl_config";
}
