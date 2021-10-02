package com.linqingxuan.datachoreography.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.HashMap;
import java.util.Map;

public class OgnlTest1 {
    public static void main(String[] args) {
        Map map = JSON.parseObject("{\"success\":false,\"errMsg\":\"未知异常\"}",
                Map.class);
        System.out.println(map);
    }
}
