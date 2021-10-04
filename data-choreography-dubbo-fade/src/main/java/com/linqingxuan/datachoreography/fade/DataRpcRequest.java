package com.linqingxuan.datachoreography.fade;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 入参
 * @author     : longchuan
 * @date       : 2021/10/2 10:18 下午
 * @description:
 * @version    :
 */
@Data
@Builder(toBuilder = true)
public class DataRpcRequest<T extends Map<String,Object>> implements Serializable {

    private static final long serialVersionUID = 3108603214724709456L;

    private T paramsMap;

    private String respClassName;

    public Class getResponseClass() throws ClassNotFoundException {
        return Class.forName(respClassName);
    }

    /**
     * dslId
     * */
    private Long dslId;
}
