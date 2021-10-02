package com.linqingxuan.datachoreography.core.dsl;


import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 任务节点
 * @author     : longchuan
 * @date       : 2021/10/2 10:16 上午
 * @description:
 * @version    :
 */
@Data
public class TaskNode implements Serializable {

    private static final long serialVersionUID = -5795089018013798231L;

    /**
     * 下属task
     * */
    private List<TaskNode> subNode;

    /**
     * 别名
     * */
    private String alias;

    /**
     * 调用 dubbo/rest/....
     * */
    private String taskType;

    /**
     * 返回成功失败判断 用于判定和取值
     * */
    private RetGenericDefinition retGenericDefinition;

    /**
     * 任务参数 dubbo则存储rpc 注册中心/入参类型/调用类/方法等
     * */
    private Map<String,Object> taskParams;

    /**
     * 所在第N个
     * */
    private String location;

    /**
     * timeout 单位：毫秒值
     * */
    private Integer timeout;
}
