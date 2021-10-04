package com.linqingxuan.datachoreography.test.dubbo.activity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动
 * @author     : longchuan
 * @date       : 2021/10/3 3:19 下午
 * @description:
 * @version    :
 */
@Data
public class ActivityDTO implements Serializable {

    private static final long serialVersionUID = -5795089018013798231L;

    /**
     * 活动id
     * */
    private Long id;

    /**
     * 活动名称
     * */
    private String name;

    /**
     * 活动类型 1-满减阶梯，2-满减
     * */
    private Integer type;

    /**
     * 是否生效
     * */
    private Boolean effectFlag;

    /**
     * 生效开始时间
     * */
    private Date effectStart;

    /**
     * 生效结束时间
     * */
    private Date effectEnd;
}
