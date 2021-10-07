package com.linqingxuan.datachoreography.dubbo.dsl;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *
 * {
 *                 "interfaceName":"com.xxx.a", //类名
 *                 "protocol":"dubbo",
 *                 "version":"1.0.0",
 *                 "method": "getByDoubleRequest", //dubbo调用方法
 *                 "registryId":"zk1",
 *                 "inputDefinitions":[
 *                     {
 *                         "fieldName": "name",
 *                         "location":1,
 *                         "className":"java.lang.String"
 *                     },
 *                     {
 *                         "location":2,
 *                         "className":"com.dianping.csc.pirate.remoting.pigeon.pigeon_generic_demo_service.HelloWorld"
 *                     }
 *                 ]
 *  }
 * 任务参数
 * @author     : longchuan
 * @date       : 2021/10/2 4:18 下午
 * @description:
 * @version    :
 */
@Data
public class DubboTaskParams implements Serializable {

    private static final long serialVersionUID = -5795089018013798231L;

    /**
     * 接口名
     * */
    private String interfaceName;

    /**
     * 协议类型
     * */
    private String protocol;

    /**
     * 接口版本
     * */
    private String version;

    /**
     * 注册中心Id
     * */
    private String registryAddr;

    /**
     * 输入类型定义
     * */
    private List<InputDefinition> inputDefinitions;

}
