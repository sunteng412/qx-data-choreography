package com.linqingxuan.datachoreography.core.dsl.jdbc.mysql;

import com.alibaba.fastjson.JSONObject;
import com.linqingxuan.datachoreography.core.dsl.DataDslAccessFactory;

import java.util.Map;

 /**
   * mysql存储实现
   * @description:
   * @author : MrFox
   * @date : 2021/10/7 22:02
  */
public class MysqlDataDslAccessFactory implements DataDslAccessFactory {
    @Override
    public Map<String, JSONObject> loaderAll() {
        return null;
    }

    @Override
    public JSONObject loaderByDslId() {
        return null;
    }
}
