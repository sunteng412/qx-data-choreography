package com.linqingxuan.datachoreography.core.dsl;


import com.alibaba.fastjson.JSONObject;
import com.linqingxuan.datachoreography.core.spi.SPI;

import java.util.Map;

/**
   * 配置加载
   * @description:
   * @author : MrFox
   * @date : 2021/10/7 18:16
  */
 @SPI
public interface DataDslAccessFactory {


      /**
        * 获取全部配置
        * @description:
        * @author : MrFox
        * @date : 2021/10/7 18:18
       */
    Map<String, JSONObject> loaderAll();


    /**
     * 根据dslId获取配置
     * @description:
     * @author : MrFox
     * @date : 2021/10/7 18:18
     */
    JSONObject loaderByDslId();
}
