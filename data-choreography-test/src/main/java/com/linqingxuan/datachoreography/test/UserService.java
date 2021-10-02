package com.linqingxuan.datachoreography.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findByName(String name){
        return userDao.findByName(name);
    }

    public void loginAfter(){
        System.out.println("登录成功");
    }

    public void login(String name, String passwd){
        User user = findByName(name);
        if (user == null){
            throw new RuntimeException(name + "不存在");
        }
        if (!user.getPasswd().equals(passwd)){
            throw new RuntimeException(name + "密码输入错误");
        }
        loginAfter();
    }
}