package com.linqingxuan.datachoreography.core.dsl.jdbc.datasource;


import com.google.common.base.Joiner;
import com.linqingxuan.datachoreography.core.dsl.jdbc.dbutils.DataSourceUtil;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * mysql数据源配置
 *
 * @author Robert HG (254963746@qq.com) on 10/24/14.
 */
@Slf4j
public class MysqlDataSourceProvider implements DataSourceProvider {

    // 同一配置, 始终保持同一个连接
    private static final ConcurrentHashMap<String, DataSource> DATA_SOURCE_MAP = new ConcurrentHashMap<String, DataSource>();

    private static final Object lock = new Object();

    @Override
    public DataSource getDataSource(Map<String, Object> dataSourceProps) {
        String jdbcUrl = (String)dataSourceProps.get("jdbcUrl");
        String cachedKey = Joiner.on("-").join(jdbcUrl,
                dataSourceProps.get("username"),
                dataSourceProps.get("password"));

        DataSource dataSource = DATA_SOURCE_MAP.get(cachedKey);
        if (dataSource == null) {
            try {
                synchronized (lock) {
                    dataSource = DATA_SOURCE_MAP.get(cachedKey);
                    if (dataSource != null) {
                        return dataSource;
                    }
                    dataSource = DataSourceUtil.getDataSource(dataSourceProps.get("type").toString(), dataSourceProps);

                    DATA_SOURCE_MAP.put(cachedKey, dataSource);
                }
            } catch (Exception e) {
                throw new IllegalStateException(
                        String.format("connect datasource failed! url: %s", jdbcUrl), e);
            }
        }
        return dataSource;
    }
}
