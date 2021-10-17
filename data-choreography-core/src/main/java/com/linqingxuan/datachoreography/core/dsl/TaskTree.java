package com.linqingxuan.datachoreography.core.dsl;


import com.google.common.collect.Maps;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 任务树
 * @author     : longchuan
 * @date       : 2021/10/2 4:36 下午
 * @description:
 * @version    :
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskTree {


    /**********************
     * 构建任务树
     * @param
     * @return
     * @description //TODO
     * @date 23:38 2021/10/16
    **********************/
    public static TaskNode buildTaskTree(List<TaskNode> taskNodes) {
        if(taskNodes.size() == 1){
            return taskNodes.get(0);
        }

        Map<String, TaskNode> taskNodeMap = taskNodes.stream().collect(Collectors.toMap(TaskNode::getAlias, Function.identity()));

        //最顶级节点,目前只允许有一个
        TaskNode topNode;

        for(Map.Entry<String, TaskNode> entry : taskNodeMap.entrySet()) {
            TaskNode entryValue = entry.getValue();
            Map<String, String> inputDependsOnMap = entryValue.getInputDependsOn();

            //判断有没有依赖其他节点的,没有的就是顶级节点
            if(MapUtils.isNotEmpty(inputDependsOnMap)){
                topNode = entryValue;
            } else {

            }
        }

        return null;
    }

}
