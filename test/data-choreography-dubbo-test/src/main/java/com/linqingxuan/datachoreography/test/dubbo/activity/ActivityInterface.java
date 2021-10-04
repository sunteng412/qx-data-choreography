package com.linqingxuan.datachoreography.test.dubbo.activity;

import com.linqingxuan.datachoreography.test.dubbo.Result;

import java.util.List;

/**
 * 活动服务
 * @author     : longchuan
 * @date       : 2021/10/3 12:01 下午
 * @description:
 * @version    :
 */
public interface ActivityInterface {

    /**
     * 根据活动id获取该活动下对应的商品
     * @param activityId 活动id
     * @param appId 店铺id
     * @return
     * @description:
     */
    Result<List<ActivityItemDTO>> getActivityItemByItem(Long activityId,
                                                        Integer appId);

    /**
     * 根据商品id获取绑定该商品的所有活动
     * @param appId 店铺id
     * @return
     * @description:
     */
    Result<List<ActivityDTO>> getActivityByCommodityId(String commodityId, Integer appId,
                                                       Integer activityType);
}
