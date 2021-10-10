package com.linqingxuan.datachoreography.core.dsl.jdbc.datasource;


import com.linqingxuan.datachoreography.core.spi.SPI;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author Robert HG (254963746@qq.com) on 10/24/14.
 */
@SPI
public interface DataSourceProvider {

    DataSource getDataSource(Map<String, Object> dataSourceProps);

}
