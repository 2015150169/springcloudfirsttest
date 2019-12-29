package com.cwh.ctrip.product.exception;

import com.cwh.ctrip.product.enums.ResultEnum;

/**
 * Created by cwh
 * 2019-12-10 22:59
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
