package com.linqingxuan.datachoreography.core.dsl.jdbc;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.linqingxuan.datachoreography.core.dsl.ChoreographyData;
import com.linqingxuan.datachoreography.core.dsl.DataDslAccessFactory;
import com.linqingxuan.datachoreography.core.utils.BizException;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
   * jdbc存储实现
   * @description:
   * @author : MrFox
   * @date : 2021/10/7 22:02
  */
public class JdbcDataDslAccessFactory extends DataDslAccessFactory {

    private static final Cache<Long,ChoreographyData> CACHE  = CacheBuilder.newBuilder()
            .expireAfterWrite(2, TimeUnit.HOURS)
            .maximumSize(3000)
            .build();

    @Override
    public Map<Long, ChoreographyData> loaderAll() {
        List<ChoreographyData> allDsl = getJdbcDataAccessAdapterFactory().getAllDsl();

        if(CollectionUtils.isNotEmpty(allDsl)){
            Map<Long, ChoreographyData> dataMap = allDsl.stream().collect(Collectors.toMap(ChoreographyData::getId, Function.identity()));
            CACHE.putAll(dataMap);
        }

        return Collections.emptyMap();
    }

    @Override
    public ChoreographyData loaderByDslId(Long dslId) {
        try {
            return CACHE.get(dslId, () -> getJdbcDataAccessAdapterFactory().getDslByDslId(dslId));
        } catch (ExecutionException e) {
            throw new BizException(String.format("找不到dsl[%s]配置", dslId));
        }
    }
}
