package com.linqingxuan.datachoreography.core.dsl.jdbc.mysql;

import com.linqingxuan.datachoreography.core.dsl.config.DataConfig;
import com.linqingxuan.datachoreography.core.dsl.jdbc.JdbcAbstractAccess;

import java.util.Map;

/**
 * mysql配置
 * @author     : longchuan
 * @date       : 2021/10/10 9:55 下午
 * @description:
 * @version    :
 */
public abstract class MysqlJdbcAbstractAccess extends JdbcAbstractAccess {
    public MysqlJdbcAbstractAccess(DataConfig dataConfig) {
        super(dataConfig);
    }

    protected abstract String getTableName();
}
