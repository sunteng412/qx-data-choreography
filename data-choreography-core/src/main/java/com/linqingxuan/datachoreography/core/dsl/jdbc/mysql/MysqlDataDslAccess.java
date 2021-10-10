package com.linqingxuan.datachoreography.core.dsl.jdbc.mysql;

import com.linqingxuan.datachoreography.core.dsl.constant.Constants;

import java.util.Map;

/**
 * mysql dsl配置
 * @param
 * @return
 * @description:
 */
public class MysqlDataDslAccess extends MysqlJdbcAbstractAccess {
    public MysqlDataDslAccess(Map<String, Object> dataSourceProps) {
        super(dataSourceProps);
        createTable(readSqlFile("sql/mysql/qx_dsl_config.sql", getTableName()));
    }

    @Override
    protected String getTableName() {
        return Constants.DSL_CONFIG_TABLE;
    }



}
