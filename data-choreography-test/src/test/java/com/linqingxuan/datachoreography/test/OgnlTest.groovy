package com.linqingxuan.datachoreography.test

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.TypeReference
import javafx.beans.binding.When
import ognl.Ognl
import ognl.OgnlContext
import spock.lang.Specification

class OgnlTest extends  Specification{


    def "test add"(){
        expect:
        Calculator.add(1, 1) == 2
    }

    def "test ognl测试返回值为false"(){
        given : "测试ognl"
        def jsonObj = JSON.parseObject("{\"success\":false,\"errMsg\":\"未知异常\"}", Map.class)
        jsonObj.get("success") == Boolean.TRUE ? print('success') :println(jsonObj)

        //创建一个Ognl上下文对象
        OgnlContext context = new OgnlContext(null,null,new DefaultMemberAccess(true));
        context.setRoot(jsonObj)
        println(Ognl.getValue("success", context.getRoot()))
        println(Ognl.getValue("success == false",context.getRoot()))
        println(Ognl.getValue("success == true and @Objects@nonNull(data) ",context.getRoot()))

    }


    def "test ognl测试返回值为true"(){
        given : "ognl测试返回值为true"
        def jsonObj = JSON.parseObject("{\"success\":true,\"data\":{\n" +
                "\t\"name\":\"小明\"\n" +
                "}}", Map.class)
        jsonObj.get("success") == Boolean.TRUE ? println('success') :println(jsonObj)

        //创建一个Ognl上下文对象
        OgnlContext context = new OgnlContext(null,null,new DefaultMemberAccess(true));
        context.setRoot(jsonObj)
        println(Ognl.getValue("success", context.getRoot()))
        println(Ognl.getValue("success == true and @java.util.Objects@nonNull(data) ",context.getRoot()))

    }


}
