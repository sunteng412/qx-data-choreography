package com.linqingxuan.datachoreography.test.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/*****
 * 启动类
 * @ Author     : MrFox
 * @ Date       : 2019-11-13 18:04
 * @ Description:
 * @ Modified By:
 * @ Version:   :
 ****/
public class DubboProviderMain {
    public static void main(String[] args) throws IOException {
        //通过spring的应用上下文加载dubbo-server.xml
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-server.xml");

        //启动
        context.start();

        //阻塞当前进程
        System.in.read();
    }
}
