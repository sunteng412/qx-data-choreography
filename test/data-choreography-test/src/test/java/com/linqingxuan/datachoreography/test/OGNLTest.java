package com.linqingxuan.datachoreography.test;

import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import ognl.Ognl;
import ognl.OgnlContext;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class OGNLTest {


    @SneakyThrows
    @Test
    public void testOgnl(){
        Map jsonObj = JSON.parseObject("{\"success\":true,\"data\":{\n" +
                "\t\"name\":\"小明\"\n" +
                "}}", Map.class);

        //创建一个Ognl上下文对象
        OgnlContext context = new OgnlContext(null,null,DefaultMemberAccess.DEFAULT_MEMBER_ACCESS);
        context.setRoot(jsonObj);
        System.out.println(Ognl.getValue("success", context.getRoot()));
        System.out.println(Ognl.getValue("success == true and @java.util.Objects@nonNull(data) ",context.getRoot()));
    }
}
