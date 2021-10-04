package com.linqingxuan.datachoreography.test.dubbo;

import com.alibaba.fastjson.JSON;
import com.linqingxuan.datachoreography.test.dubbo.activity.ActivityDTO;
import com.linqingxuan.datachoreography.test.dubbo.activity.ActivityInterface;
import com.linqingxuan.datachoreography.test.dubbo.activity.ActivityItemDTO;
import com.linqingxuan.datachoreography.test.dubbo.item.ItemDTO;
import com.linqingxuan.datachoreography.test.dubbo.item.ItemInterface;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

public class DubboConsumerMain {

    public static void main(String[] args) {
        //通过spring的应用上下文加载dubbo-client.xml
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-client.xml");
        ActivityInterface activityInterface = (ActivityInterface) context.getBean("activityInterface");
        ItemInterface itemInterface = (ItemInterface) context.getBean("itemInterface");

        Result<List<ActivityDTO>> activityByCommodityId = activityInterface.getActivityByCommodityId("110", 1, 2);
        System.out.println("[getActivityByCommodityId]：" + JSON.toJSONString(activityByCommodityId));

        Result<List<ActivityItemDTO>> activityItemByItem = activityInterface.getActivityItemByItem(activityByCommodityId.getValue().get(0).getId(), 1);
        System.out.println("[getActivityItemByItem]：" + JSON.toJSONString(activityItemByItem.getValue()));

        List<ActivityItemDTO> value = activityItemByItem.getValue();
        Result<List<ItemDTO>> itemList = itemInterface.getItemList(value.stream().map(ActivityItemDTO::getCommodityId).collect(Collectors.toList()),
                1);
        System.out.println("[getItemList]：" + JSON.toJSONString(itemList.getValue()));

    }
}
