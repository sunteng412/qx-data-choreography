package com.linqingxuan.datachoreography.core.dsl.jdbc;

import com.linqingxuan.datachoreography.core.dsl.config.DataConfig;
import com.linqingxuan.datachoreography.core.dsl.constant.Constants;
import com.linqingxuan.datachoreography.core.dsl.constant.ExtConfig;
import com.linqingxuan.datachoreography.core.dsl.file.FileUtils;
import com.linqingxuan.datachoreography.core.dsl.jdbc.exception.JdbcException;
import com.linqingxuan.datachoreography.core.utils.BizException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * 表映射实体领域对象
 * @author     : longchuan
 * @date       : 2021/10/9 5:57 下午
 * @description:
 * @version    :
 */
public abstract class JdbcAbstractAccess {

    private SqlTemplate sqlTemplate;
    private Map<String, Object> dataSourceProps;

    public JdbcAbstractAccess(DataConfig dataConfig) {
        this.dataSourceProps = dataConfig.getDataSourceProps();
        this.sqlTemplate = SqlTemplateFactory.create(dataConfig);
    }

    public SqlTemplate getSqlTemplate() {
        return sqlTemplate;
    }

    protected String readSqlFile(String path) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(path);
        try {
            return FileUtils.read(is, Constants.CHARSET);
        } catch (IOException e) {
            throw new BizException("Read sql file : [" + path + "] error ", e);
        }
    }

    protected String readSqlFile(String path, String tableName) {
        String sql = readSqlFile(path);
        return sql.replace("{tableName}", tableName);
    }

    protected void createTable(String sql) throws JdbcException {
        if (ExtConfig.getParams(dataSourceProps,ExtConfig.NEED_CREATE_TABLE)) {
            try {
                getSqlTemplate().createTable(sql);
            } catch (Exception e) {
                throw new JdbcException("Create table error, sql=" + sql, e);
            }
        }
    }
}
