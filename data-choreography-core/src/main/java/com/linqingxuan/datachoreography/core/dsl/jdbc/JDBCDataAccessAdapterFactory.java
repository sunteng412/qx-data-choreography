package com.linqingxuan.datachoreography.core.dsl.jdbc;


import com.linqingxuan.datachoreography.core.dsl.ChoreographyData;
import com.linqingxuan.datachoreography.core.spi.SPI;

import java.util.List;

/**
 * 数据处理
 *
 * @author : MrFox
 * @description:
 * @date : 2021/10/12 23:45
 */
@SPI("mysql")
public interface JDBCDataAccessAdapterFactory {

    /**********************
     * 获取所有配置
     * @param
     * @return
     * @description //TODO
     * @date 23:47 2021/10/12
     **********************/
    List<ChoreographyData> getAllDsl();

    /**********************
     * 获取所有配置
     * @param
     * @return
     * @description //TODO
     * @date 23:47 2021/10/12
     **********************/
    ChoreographyData getDslByDslId(Long dslId);

}
