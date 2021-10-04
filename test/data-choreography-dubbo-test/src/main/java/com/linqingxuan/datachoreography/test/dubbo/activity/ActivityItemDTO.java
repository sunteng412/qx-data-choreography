package com.linqingxuan.datachoreography.test.dubbo.activity;

import lombok.Data;

import java.io.Serializable;

/**
 * 活动绑定的商品
 * @author     : longchuan
 * @date       : 2021/10/3 3:12 下午
 * @description:
 * @version    :
 */
@Data
public class ActivityItemDTO implements Serializable {

    private static final long serialVersionUID = -5795089018013798231L;

    /**
     * 活动id
     * */
    private Long activityId;

    /**
     * 商品id
     * */
    private String commodityId;

    /**
     * 商品活动价
     * */
    private Long activityPrice;


}
