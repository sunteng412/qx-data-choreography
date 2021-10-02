package com.linqingxuan.datachoreography.test;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDao {

    /**
     * 模拟数据库
     */
    private static Map<String, User> userMap = new HashMap<>();
    static {
        userMap.put("k",new User("k", 1, "123"));
        userMap.put("i",new User("i", 2, "456"));
        userMap.put("w",new User("w", 3, "789"));
    }

    /**
     * 通过用户名查询用户
     * @param name
     * @return
     */
    public User findByName(String name){
        return userMap.get(name);
    }
}