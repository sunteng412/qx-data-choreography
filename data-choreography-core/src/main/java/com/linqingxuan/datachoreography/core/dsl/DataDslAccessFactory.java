package com.linqingxuan.datachoreography.core.dsl;


import com.linqingxuan.datachoreography.core.dsl.config.DataConfig;
import com.linqingxuan.datachoreography.core.dsl.constant.ExtConfig;
import com.linqingxuan.datachoreography.core.dsl.jdbc.JDBCDataAccessAdapterFactory;
import com.linqingxuan.datachoreography.core.spi.ExtensionLoader;
import com.linqingxuan.datachoreography.core.spi.SPI;
import lombok.Getter;

import java.util.Map;

/**
   * 配置加载
   * @description:
   * @author : MrFox
   * @date : 2021/10/7 18:16
  */
 @SPI(value = "jdbc")
public abstract class DataDslAccessFactory {

     @Getter
    public JDBCDataAccessAdapterFactory jdbcDataAccessAdapterFactory;

     void init(DataConfig dataConfig){
         jdbcDataAccessAdapterFactory = ExtensionLoader.getExtensionLoader(JDBCDataAccessAdapterFactory.class)
                 .getJoin(ExtConfig.getParams(dataConfig.getDataProps(),ExtConfig.DATA_DSL_ACCESS));
     }


      /**
        * 获取全部配置
        * @description:
        * @author : MrFox
        * @date : 2021/10/7 18:18
       */
    public abstract Map<Long, ChoreographyData> loaderAll();


    /**
     * 根据dslId获取配置
     * @description:
     * @author : MrFox
     * @date : 2021/10/7 18:18
     */
    public abstract ChoreographyData loaderByDslId(Long dslId);

}
