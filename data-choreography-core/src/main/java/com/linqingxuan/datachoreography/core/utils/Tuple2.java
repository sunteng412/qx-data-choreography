package com.linqingxuan.datachoreography.core.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 元组 2
 * @author     : longchuan
 * @date       : 2021/10/2 3:54 下午
 * @description:
 * @version    :
 */
@Data
@AllArgsConstructor
public class Tuple2<T,F> implements Serializable {

    private static final long serialVersionUID = -5795089018013798231L;

    private T first;
    private F second;
}
