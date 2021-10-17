package com.linqingxuan.datachoreography.core.dsl.constant;

import lombok.Getter;

import java.util.Map;

public enum ExtConfig {

    /**
     * 数据源spi
     * */
    DATASOURCE_DSL_ACCESS("dataSourceDslAccess","jdbc"),

    /**
     * 数据库-数据源spi
     * */
    DATA_DSL_ACCESS("dataDslAccess","mysql"),

    /**
     * 数据库-数据源spi
     * */
    DSL_ACCESS_SPI ("dslAccessSpi","mysql"),


    /**
     * 数据库-自动创建表
     * */
    NEED_CREATE_TABLE ("autoCreateTable",Boolean.TRUE);

    @Getter
    private String fieldName;

    @Getter
    private Object dftValue;



    public static <F> F getParams( Map<String, Object> objectMap,ExtConfig extConfig){
        return (F) objectMap.getOrDefault(extConfig.fieldName,extConfig.dftValue);
    }

    ExtConfig(String fieldName, Object dftValue) {
        this.fieldName = fieldName;
        this.dftValue = dftValue;
    }
}
