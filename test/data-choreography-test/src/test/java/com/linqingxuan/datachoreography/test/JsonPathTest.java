package com.linqingxuan.datachoreography.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.JsonPath;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class JsonPathTest {


    @DisplayName("测试jsonpath获取数组中某个为xx的对象元素")
    @SneakyThrows
    @Test
    public void TestJson(){
        String json = "{\"success\":true,\"class\":\"com.linqingxuan.datachoreography.test.dubbo.Result\",\"value\":[{\"effectFlag\":false,\"name\":\"活动满减-不可用\",\"id\":3,\"type\":2,\"class\":\"com.linqingxuan.datachoreography.test.dubbo.activity.ActivityDTO\"},{\"effectFlag\":true,\"name\":\"活动阶梯满减-类型错误\",\"id\":2,\"type\":1,\"class\":\"com.linqingxuan.datachoreography.test.dubbo.activity.ActivityDTO\"},{\"effectFlag\":true,\"name\":\"活动满减\",\"id\":1,\"type\":2,\"class\":\"com.linqingxuan.datachoreography.test.dubbo.activity.ActivityDTO\"}]}";
        HashMap parseObject = JSON.parseObject(json, HashMap.class);
        Object read = JsonPath.read(parseObject, "$.value[?(@.effectFlag == true)] ");
        System.out.println(read);
    }

    @DisplayName("测试jsonpath-判断值是否正确")
    @SneakyThrows
    @Test
    public void TestJson1(){
        String json = "{\"success\":false,\"errorMessage\":\"错误\"}";
        HashMap parseObject = JSON.parseObject(json, HashMap.class);
        Object read = JsonPath.read(parseObject, "$..[?(@.success == false)].errorMessage");
        System.out.println(read);
    }
}
