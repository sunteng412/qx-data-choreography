package com.linqingxuan.datachoreography.core.dsl.constant;

import lombok.Getter;

import java.util.Map;

public enum ExtConfig {

    /**
     * 数据库-数据源spi
     * */
    DB_SPI ("dbSpi","mysql"),

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
