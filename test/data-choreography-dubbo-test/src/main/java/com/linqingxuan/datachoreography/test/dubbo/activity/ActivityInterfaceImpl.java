package com.linqingxuan.datachoreography.test.dubbo.activity;

import com.google.common.collect.Lists;
import com.linqingxuan.datachoreography.test.dubbo.Result;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 活动实现
 * @author     : longchuan
 * @date       : 2021/10/3 3:27 下午
 * @description:
 * @version    :
 */
public class ActivityInterfaceImpl implements ActivityInterface{


    /**
     * 根据活动id获取该活动下对应的商品
     *
     * @param activityId   活动id
     * @param appId        店铺id
     * @return
     * @description:
     */
    @Override
    public Result<List<ActivityItemDTO>> getActivityItemByItem(Long activityId, Integer appId) {
        ActivityItemDTO activityItemDTO = new ActivityItemDTO();
        activityItemDTO.setActivityId(1L);
        activityItemDTO.setActivityPrice(99L);
        activityItemDTO.setCommodityId("110");

        ActivityItemDTO activityItemDTO1 = new ActivityItemDTO();
        activityItemDTO1.setActivityId(1L);
        activityItemDTO1.setActivityPrice(98L);
        activityItemDTO1.setCommodityId("111");

        ActivityItemDTO activityItemDTO2 = new ActivityItemDTO();
        activityItemDTO2.setActivityId(1L);
        activityItemDTO2.setActivityPrice(999L);
        activityItemDTO2.setCommodityId("112");

        return Result.newSuccessResult((List<ActivityItemDTO>)Lists.newArrayList(activityItemDTO1,activityItemDTO));
    }

    /**
     * 根据商品id获取绑定该商品的所有活动
     * @param appId      店铺id
     * @return
     * @description:
     */
    @Override
    public Result<List<ActivityDTO>> getActivityByCommodityId(String commodityId, Integer appId,
                                                              Integer activityType){
        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setEffectFlag(Boolean.FALSE);
        activityDTO.setName("活动满减-不可用");
        activityDTO.setType(2);
        activityDTO.setId(3L);

        ActivityDTO activityDTO1 = new ActivityDTO();
        activityDTO1.setEffectFlag(Boolean.TRUE);
        activityDTO1.setName("活动阶梯满减-类型错误");
        activityDTO1.setType(1);
        activityDTO1.setId(2L);

        ActivityDTO activityDTO2 = new ActivityDTO();
        activityDTO2.setEffectFlag(Boolean.TRUE);
        activityDTO2.setName("活动满减");
        activityDTO2.setType(2);
        activityDTO2.setId(1L);
        return Result.newSuccessResult((List<ActivityDTO>) Lists.newArrayList(activityDTO,activityDTO1,activityDTO2));
    }
}
