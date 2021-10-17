package com.linqingxuan.datachoreography.core.dsl.jdbc.mysql;

import com.linqingxuan.datachoreography.core.dsl.config.DataConfig;
import com.linqingxuan.datachoreography.core.dsl.constant.Constants;
import com.linqingxuan.datachoreography.core.dsl.jdbc.RshHandler;
import com.linqingxuan.datachoreography.core.dsl.jdbc.builder.SelectSql;

import java.util.List;
import java.util.Map;

/**
 * mysql dsl配置
 * @param
 * @return
 * @description:
 */
public class MysqlDataDslTaskAccess extends MysqlJdbcAbstractAccess {

    public MysqlDataDslTaskAccess(DataConfig dataConfig) {
        super(dataConfig);
        createTable(readSqlFile("sql/mysql/qx_dsl_task.sql", getTableName()));
    }

    @Override
    protected String getTableName() {
        return Constants.DSL_TASK_CONFIG_TABLE;
    }


    public List<DslTaskConfig> getTaskByDslId(Long dslId) {
        return new SelectSql(getSqlTemplate())
                .select()
                .columns("id",
                        "dsl_id",
                        "task_alias taskAlias",
                        "task_desc taskDesc",
                        "ret_generic_definition retGenericDefinition",
                        "task_params taskParams",
                        "task_type taskType",
                        "location",
                        "input_depends_on inputDependsOn",
                        "timeout",
                        "max_retry_times maxRetryTimes")
                .from()
                .where("dsl_id",dslId)
                .table(getTableName())
                .list(RshHandler.LIST_TASK_RSH);
    }
}
