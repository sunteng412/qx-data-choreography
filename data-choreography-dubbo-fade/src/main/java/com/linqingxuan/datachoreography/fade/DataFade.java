package com.linqingxuan.datachoreography.fade;


import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * rpc请求执行入口
 *
 * @author Mr.Xihua
 * @email xihua.zh@raycloud.com
 * @date 2021-07-29 16:08
 * @description
 */
public interface DataFade {

    /**
     * 执行数据
     *
     * @param request 入参 T为所有入参map
     * @return
     * @description:
     */
    default <T extends Map<String, Object>, F> UniversalRpcResponse<F> execute(DataRpcRequest<T> request) throws ClassNotFoundException {
        UniversalRpcResponse<Map<String, Object>> mapUniversalRpcResponse = innerExec(request);
        if (mapUniversalRpcResponse.getIsSuccess()) {
            return (UniversalRpcResponse<F>) UniversalRpcResponse.builder().isSuccess(Boolean.TRUE).data(
                    JSON.parseObject(JSON.toJSONString(mapUniversalRpcResponse.getData()), request.getResponseClass())
            )
                    .build();
        }
        return (UniversalRpcResponse<F>) UniversalRpcResponse.builder().isSuccess(Boolean.FALSE).errorMsg(mapUniversalRpcResponse.getErrorMsg())
                .build();
    }

    /**
     * 内部执行的接口-未做转换
     *
     * @param
     * @return
     * @description:
     */
    <T extends Map<String, Object>> UniversalRpcResponse<Map<String, Object>> innerExec(DataRpcRequest<T> request);


}