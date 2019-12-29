package com.cwh.ctrip.order.enums;

import lombok.Getter;

/**
 * Created by cwh
 * 2019-12-10 17:32
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(1, "参数错误"),
    CART_EMPTY(2, "购物车为空")

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
