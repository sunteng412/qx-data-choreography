package com.linqingxuan.datachoreography.core.dsl.jdbc.mysql;

import com.linqingxuan.datachoreography.core.dsl.ChoreographyData;
import com.linqingxuan.datachoreography.core.dsl.DataAppContext;
import com.linqingxuan.datachoreography.core.dsl.jdbc.JDBCDataAccessAdapterFactory;
import com.linqingxuan.datachoreography.core.dsl.jdbc.mysql.convert.ChoreographyDataDomain;
import com.linqingxuan.datachoreography.core.utils.Assert;
import com.linqingxuan.datachoreography.core.utils.Tuple2;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MysqlDataAccessAdapterFactory implements JDBCDataAccessAdapterFactory {

    private MysqlDataDslAccess mysqlDataDslAccess;

    private MysqlDataDslTaskAccess mysqlDataDslTaskAccess;

    private static final Object lock = new Object();

    public MysqlDataAccessAdapterFactory() {
        super();
        init();
    }

    /**********************
     * 初始化mysql查询
     * @param
     * @return
     * @description //TODO
     * @date 23:31 2021/10/13
    **********************/
    @Override
    public void init(){
        if(Objects.isNull(mysqlDataDslAccess) && Objects.isNull(mysqlDataDslTaskAccess)){
            synchronized (lock){
                if(Objects.isNull(mysqlDataDslAccess) && Objects.isNull(mysqlDataDslTaskAccess)){
                    mysqlDataDslAccess = new MysqlDataDslAccess(DataAppContext.getDataConfig());
                    mysqlDataDslTaskAccess = new MysqlDataDslTaskAccess(DataAppContext.getDataConfig());
                }
            }
        }
    }


    @Override
    public List<ChoreographyData> getAllDsl() {
        int page = 0;
        Integer pageSize = 1000;
        Tuple2<Boolean, List<DslConfig>> tuple2 = new Tuple2<>(Boolean.TRUE,null);

        List<ChoreographyData> finalList = new ArrayList<>();
        while (tuple2.getFirst()){
            if(CollectionUtils.isNotEmpty(tuple2.getSecond())){
               finalList.addAll(tuple2.getSecond().stream().map(e -> {
                   List<DslTaskConfig> taskByDslId = mysqlDataDslTaskAccess.getTaskByDslId(e.getId());
                   Assert.notEmpty(taskByDslId, "子任务不能为空");
                   return ChoreographyDataDomain.convert(e, taskByDslId);
               }).collect(Collectors.toList()));
            }
            tuple2 = mysqlDataDslAccess.queryAllConfig(page ++, pageSize);

        }

        return finalList;
    }


    @Override
    public ChoreographyData getDslByDslId(Long dslId) {
        DslConfig dslConfig = mysqlDataDslAccess.queryConfigById(dslId);
        List<DslTaskConfig> taskByDslId = mysqlDataDslTaskAccess.getTaskByDslId(dslConfig.getId());
        Assert.notEmpty(taskByDslId, "子任务不能为空");
        return ChoreographyDataDomain.convert(dslConfig, taskByDslId);
    }
}
