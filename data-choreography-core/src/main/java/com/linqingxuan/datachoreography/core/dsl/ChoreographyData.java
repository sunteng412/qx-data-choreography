package com.linqingxuan.datachoreography.core.dsl;

import com.linqingxuan.datachoreography.core.utils.Tuple2;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 编排数据语言实体
 * @author     : longchuan
 * @date       : 2021/10/2 10:13 上午
 * @description:
 * @version    :
 */
@Data
public class ChoreographyData implements Serializable {

    private static final long serialVersionUID = -5795089018013798231L;

    /**
     * 头个节点 任务树
     * */
    private TaskNode taskTree;

    /**
     * 所有任务
     * */
    private List<TaskNode> allTaskNode;

    /**
     * dsl name
     * */
    private String name;

    /**
     * dsl Id
     * */
    private Long id;


    /**
     * dsl 备注
     * */
    private String dslDesc;


    /**
     * dsl 返回参数映射
     * */
    private Map<String,String> outputs;


}
