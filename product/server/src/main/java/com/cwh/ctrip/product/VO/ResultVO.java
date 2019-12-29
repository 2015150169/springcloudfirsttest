package com.cwh.ctrip.product.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * Created by cwh
 * 2019-12-09 22:09
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
