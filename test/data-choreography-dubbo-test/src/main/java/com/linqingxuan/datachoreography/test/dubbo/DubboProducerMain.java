package com.linqingxuan.datachoreography.test.dubbo;


import com.alibaba.dubbo.container.Main;

/*****
 * 使用main方式直接启动
 * @ Author     : MrFox
 * @ Date       : 2019-11-13 21:14
 * @ Description:
 * @ Modified By:
 * @ Version:   :
 ****/
public class DubboProducerMain {
    public static void main(String[] args) {
        Main.main(new String[]{"spring","log4j"});
    }
}
