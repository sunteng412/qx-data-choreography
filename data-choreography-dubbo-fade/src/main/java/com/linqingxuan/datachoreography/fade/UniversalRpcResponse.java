package com.linqingxuan.datachoreography.fade;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 通用RPC响应
 * @author Mr.Xihua
 * @email xihua.zh@raycloud.com
 * @date 2021-07-29 16:06
 * @description
 */
@Data
@Builder(toBuilder = true)
public class UniversalRpcResponse<T> implements Serializable {

    private static final long serialVersionUID = 3108603214724709456L;

    private T data;

    private String errorMsg;

    private Boolean isSuccess;

}
