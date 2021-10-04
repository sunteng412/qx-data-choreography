package com.linqingxuan.datachoreography.dubbo.dsl.registry;

import com.linqingxuan.datachoreography.core.spi.SPI;

/**
 * 注册中心
 * @author     : longchuan
 * @date       : 2021/10/2 4:47 下午
 * @description:
 * @version    :
 */
@SPI
public interface RegistryCenter {

    String getRegistryId();


    String getRegistryAddr();

}
