package com.linqingxuan.datachoreography.dubbo.dsl.registry;

import lombok.Getter;
import lombok.Setter;

/**
 * zk注册中心
 * @author     : longchuan
 * @date       : 2021/10/2 4:53 下午
 * @description:
 * @version    :
 */
public class ZookeeperRegistryCenter implements RegistryCenter{

    /**
     * 注册id
     **/
    @Setter
    @Getter
    String registryId;

    /**
     * 注册地址
     **/
    @Setter
    @Getter
    String registryAddr;

}
