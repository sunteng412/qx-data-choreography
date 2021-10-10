package com.linqingxuan.datachoreography.core.dsl.jdbc.mysql;

import com.linqingxuan.datachoreography.core.dsl.constant.Constants;

import java.util.Map;

/**
 * mysql dsl配置
 * @param
 * @return
 * @description:
 */
public class MysqlDataDslTaskAccess extends MysqlJdbcAbstractAccess {
    public MysqlDataDslTaskAccess(Map<String, Object> dataSourceProps) {
        super(dataSourceProps);
        createTable(readSqlFile("sql/mysql/qx_dsl_task.sql", getTableName()));
    }

    @Override
    protected String getTableName() {
        return Constants.DSL_TASK_CONFIG_TABLE;
    }



}
