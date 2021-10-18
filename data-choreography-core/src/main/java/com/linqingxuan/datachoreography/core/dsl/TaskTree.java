package com.linqingxuan.datachoreography.core.dsl;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.linqingxuan.datachoreography.core.utils.Assert;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 任务树
 *
 * @author : longchuan
 * @version :
 * @date : 2021/10/2 4:36 下午
 * @description:
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
        if (taskNodes.size() == 1) {
            return taskNodes.get(0);
        }

        Map<String, TaskNode> taskNodeMap = taskNodes.stream().collect(Collectors.toMap(TaskNode::getAlias, Function.identity()));

        //最顶级节点,目前只允许有一个
        TaskNode topNode = null;

        boolean allNoDependOn = Boolean.TRUE;

        for (Map.Entry<String, TaskNode> entry : taskNodeMap.entrySet()) {
            TaskNode entryValue = entry.getValue();
            Map<String, TaskInputDependsOn> inputDependsOnMap = entryValue.getInputDependsOn();

            //判断有没有依赖其他节点的,没有的就是顶级节点
            for (Map.Entry<String, TaskInputDependsOn> dependsOnEntry : inputDependsOnMap.entrySet()) {
                TaskInputDependsOn value = dependsOnEntry.getValue();
                if (StringUtils.isNotEmpty(value.getDependsOnTask()) && taskNodeMap.containsKey(value.getDependsOnTask())) {
                    //组装依赖
                    allNoDependOn = Boolean.FALSE;
                    TaskNode parentTaskNode = taskNodeMap.get(value.getDependsOnTask());

                    if (CollectionUtils.isEmpty(entryValue.getParentNode())) {

                        entryValue.setParentNode(Lists.newArrayList(parentTaskNode));

                    } else {
                        entryValue.getParentNode().add(parentTaskNode);
                    }

                    if (CollectionUtils.isEmpty(parentTaskNode.getSubNode())) {
                        parentTaskNode.setSubNode(Lists.newArrayList(entryValue));
                    } else {
                        parentTaskNode.getSubNode().add(entryValue);
                    }
                }


            }

            if(Objects.isNull(topNode) && allNoDependOn) {
                topNode = entryValue;
            }
            allNoDependOn = Boolean.TRUE;
        }

        return topNode;
    }

}
