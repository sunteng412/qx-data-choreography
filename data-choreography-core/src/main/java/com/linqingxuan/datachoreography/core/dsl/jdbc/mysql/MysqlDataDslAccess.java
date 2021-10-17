package com.linqingxuan.datachoreography.core.dsl.jdbc.mysql;

import com.linqingxuan.datachoreography.core.dsl.config.DataConfig;
import com.linqingxuan.datachoreography.core.dsl.constant.Constants;
import com.linqingxuan.datachoreography.core.dsl.jdbc.RshHandler;
import com.linqingxuan.datachoreography.core.dsl.jdbc.builder.SelectSql;
import com.linqingxuan.datachoreography.core.utils.Tuple2;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * mysql dsl配置
 * @param
 * @return
 * @description:
 */
public class MysqlDataDslAccess extends MysqlJdbcAbstractAccess {
    public MysqlDataDslAccess(DataConfig dataConfig) {
        super(dataConfig);
        createTable(readSqlFile("sql/mysql/qx_dsl_config.sql", getTableName()));
    }

    @Override
    protected String getTableName() {
        return Constants.DSL_CONFIG_TABLE;
    }


    /**********************
     * 分页查询所有
     * @param
     * @return
     * @description //TODO
     * @date 23:40 2021/10/13
    **********************/
    public Tuple2<Boolean, List<DslConfig>> queryAllConfig(
            Integer page,Integer pageSize
    ) {
        List<DslConfig> dslConfigs = new SelectSql(getSqlTemplate())
                .select()
                .columns("id",
                        "name",
                        "dsl_desc dslDesc",
                        "outputs outputs",
                        "timeout",
                        "max_retry_times maxRetryTimes")
                .from()
                .table(getTableName())
                .limit((page - 1) * pageSize, pageSize)
                .list(RshHandler.LIST_RSH);

        if(CollectionUtils.isNotEmpty(dslConfigs) && dslConfigs.size() == pageSize){
            return new Tuple2<>(Boolean.TRUE,dslConfigs);
        }
        return new Tuple2<>(Boolean.FALSE,dslConfigs);
    }

    /**********************
     * 分页单个
     * @param
     * @return
     * @description //TODO
     * @date 23:40 2021/10/13
     **********************/
    public DslConfig queryConfigById(
            Long id
    ) {
       return   new SelectSql(getSqlTemplate())
                .select()
                .columns("id",
                        "name",
                        "dsl_desc dslDesc",
                        "outputs outputs",
                        "timeout",
                        "max_retry_times maxRetryTimes")
                .from()
               .where("id",id)
                .table(getTableName())
                .single(RshHandler.SINGLE_RSH);

    }

}
