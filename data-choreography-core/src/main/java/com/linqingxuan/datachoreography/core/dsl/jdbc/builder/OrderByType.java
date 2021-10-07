package com.linqingxuan.datachoreography.core.dsl.jdbc.builder;


import org.apache.commons.lang3.StringUtils;

/**
 * @author Robert HG (254963746@qq.com) on 3/8/16.
 */
public enum OrderByType {
    DESC, ASC;

    public static OrderByType convert(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return OrderByType.valueOf(value);
    }

}
