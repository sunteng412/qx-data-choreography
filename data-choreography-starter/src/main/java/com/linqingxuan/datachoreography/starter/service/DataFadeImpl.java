package com.linqingxuan.datachoreography.starter.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.linqingxuan.datachoreography.fade.DataFade;
import com.linqingxuan.datachoreography.fade.DataRpcRequest;
import com.linqingxuan.datachoreography.fade.UniversalRpcResponse;

import java.util.Map;

/**
 * 动态化调用门面实现
 * @author     : longchuan
 * @date       : 2021/10/3 10:33 上午
 * @description:
 * @version    :
 */
@Service(version = "${dubbo.service.version.dataFade}")
public class DataFadeImpl implements DataFade {

    /**
     * 内部执行的接口-未做转换
     *
     * @param request@return
     * @description:
     */
    @Override
    public <T extends Map<String, Object>> UniversalRpcResponse<Map<String, Object>> innerExec(DataRpcRequest<T> request) {
        return null;
    }
}
