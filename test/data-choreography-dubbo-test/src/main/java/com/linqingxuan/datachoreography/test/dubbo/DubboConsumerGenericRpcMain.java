package com.linqingxuan.datachoreography.test.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.alibaba.fastjson.JSON;

/**
 * 泛华调用
 * @author     : longchuan
 * @date       : 2021/10/4 7:40 下午
 * @description:
 * @version    :
 */
public class DubboConsumerGenericRpcMain {
    public static void main(String[] args) {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        // 当前dubbo consumer的application配置，不设置会直接抛异常
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("generic_test_service");
        // 注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        // 注册中心这里需要配置上注册中心协议，例如下面的zookeeper
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
        reference.setApplication(applicationConfig);
        reference.setRegistry(registryConfig);
        // 设置调用的reference属性，下面只设置了协议、接口名、版本、超时时间
        reference.setProtocol("dubbo");
        reference.setInterface("com.linqingxuan.datachoreography.test.dubbo.activity.ActivityInterface");
        reference.setVersion("1.0.0");
        reference.setTimeout(1000);
        // 声明为泛化接口
        reference.setGeneric(true);
        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GenericService genericService = cache.get(reference);

        // GenericService可以接住所有的实现
        Object result = genericService.$invoke("getActivityByCommodityId", new String[]{"java.lang.String", "java.lang.Integer", "java.lang.Integer"}, new Object[]{"110", "1",1});
        System.out.println(JSON.toJSONString(result));
    }
}
