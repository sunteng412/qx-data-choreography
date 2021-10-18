package com.linqingxuan.datachoreography.core.dsl.jdbc.mysql.convert;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.linqingxuan.datachoreography.core.dsl.*;
import com.linqingxuan.datachoreography.core.dsl.jdbc.mysql.DslConfig;
import com.linqingxuan.datachoreography.core.dsl.jdbc.mysql.DslTaskConfig;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 配置
 *
 * @author : MrFox
 * @description:
 * @date : 2021/10/16 21:11
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChoreographyDataDomain {

     private static final TypeReference<Map<String,String>> OUTPUTS_CONFIG = new TypeReference<Map<String,String>>(){};

    private static final TypeReference<Map<String, TaskInputDependsOn>> INPUT_DEPENDS_ON_CONFIG = new TypeReference<Map<String,TaskInputDependsOn>>(){};

    private static final TypeReference<Map<String,Object>> TASK_PARAMS_CONFIG = new TypeReference<Map<String,Object>>(){};


    /**********************
     * 组装mysql实体
     * @param
     * @return
     * @description //TODO
     * @date 21:31 2021/10/16
    **********************/
    public static ChoreographyData convert(DslConfig config, List<DslTaskConfig> taskByDslId) {
        ChoreographyData choreographyData = new ChoreographyData();
        choreographyData.setDslDesc(config.getDslDesc());
        choreographyData.setId(config.getId());
        choreographyData.setName(config.getName());
        choreographyData.setOutputs(JSON.parseObject(config.getOutputs(),OUTPUTS_CONFIG));

        List<TaskNode> taskNodes = convertTaskNode(taskByDslId);
        choreographyData.setAllTaskNode(taskNodes);
        choreographyData.setTaskTree(TaskTree.buildTaskTree(taskNodes));
        return choreographyData;
    }


    private static List<TaskNode> convertTaskNode(List<DslTaskConfig> taskByDslId) {
        return taskByDslId.stream().map(e->{
            TaskNode taskNode = new TaskNode();
            taskNode.setTaskType(e.getTaskType());
            taskNode.setAlias(e.getTaskAlias());
            taskNode.setLocation(e.getLocation());
            taskNode.setTimeout(e.getTimeout());
            taskNode.setRetGenericDefinition(JSON.parseObject(e.getRetGenericDefinition(), RetGenericDefinition.class));
            taskNode.setInputDependsOn(JSON.parseObject(e.getInputDependsOn(),INPUT_DEPENDS_ON_CONFIG));
            taskNode.setTaskParams(JSON.parseObject(e.getTaskParams(),TASK_PARAMS_CONFIG));
            return taskNode;
        }).collect(Collectors.toList());
    }


}
