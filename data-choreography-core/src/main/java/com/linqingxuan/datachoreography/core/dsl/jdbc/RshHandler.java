package com.linqingxuan.datachoreography.core.dsl.jdbc;

import com.linqingxuan.datachoreography.core.dsl.jdbc.dbutils.ResultSetHandler;
import com.linqingxuan.datachoreography.core.dsl.jdbc.mysql.DslConfig;
import com.linqingxuan.datachoreography.core.dsl.jdbc.mysql.DslTaskConfig;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RshHandler {

    public static final ResultSetHandler<List<DslConfig>> LIST_RSH = new ResultSetHandler<List<DslConfig>>() {
        @Override
        public List<DslConfig> handle(ResultSet rs) throws SQLException {
            List<DslConfig> nodes = new ArrayList<>();
            while (rs.next()) {
                nodes.add(getDslConfigByRs(rs));
            }
            return nodes;
        }
    };

    public static final ResultSetHandler<DslConfig> SINGLE_RSH = new ResultSetHandler<DslConfig>() {
        @Override
        public DslConfig handle(ResultSet rs) throws SQLException {
            if(rs.getRow() == 0){
                return null;
            }
            return getDslConfigByRs(rs);
        }
    };

    public static final ResultSetHandler<List<DslTaskConfig>> LIST_TASK_RSH = new ResultSetHandler<List<DslTaskConfig>>() {
        @Override
        public List<DslTaskConfig> handle(ResultSet rs) throws SQLException {
            List<DslTaskConfig> nodes = new ArrayList<>();
            while (rs.next()) {
                nodes.add(getDslTaskConfigByRs(rs));
            }
            return nodes;
        }
    };

    private static DslTaskConfig getDslTaskConfigByRs(ResultSet rs) throws SQLException {

        DslTaskConfig dslConfig = new DslTaskConfig();

        dslConfig.setId(rs.getLong("id"));
        dslConfig.setDslId(rs.getLong("dslId"));
        dslConfig.setTaskAlias(rs.getString("taskAlias"));
        dslConfig.setTaskDesc(rs.getString("taskDesc"));
        dslConfig.setRetGenericDefinition(rs.getString("retGenericDefinition"));
        dslConfig.setTaskParams(rs.getString("taskParams"));
        dslConfig.setTaskType(rs.getString("taskType"));
        dslConfig.setLocation(rs.getInt("location"));
        dslConfig.setInputDependsOn(rs.getString("inputDependsOn"));
        dslConfig.setTimeout(rs.getLong("timeout"));
        dslConfig.setMaxRetryTimes(rs.getInt("maxRetryTimes"));
        return dslConfig;

    }

    private static DslConfig getDslConfigByRs(ResultSet rs) throws SQLException {

            DslConfig dslConfig = new DslConfig();
            dslConfig.setDslDesc(rs.getString("dslDesc"));
            dslConfig.setId(rs.getLong("id"));
            dslConfig.setName(rs.getString("name"));
            dslConfig.setOutputs(rs.getString("outputs"));
            dslConfig.setTimeout(rs.getLong("timeout"));
            dslConfig.setMaxRetryTimes(rs.getInt("maxRetryTimes"));
            return dslConfig;

    }

}
