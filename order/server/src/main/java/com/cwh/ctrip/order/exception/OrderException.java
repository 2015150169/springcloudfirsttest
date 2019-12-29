package com.cwh.ctrip.order.exception;

import com.cwh.ctrip.order.enums.ResultEnum;

/**
 * Created by cwh
 * 2019-12-10 17:27
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
