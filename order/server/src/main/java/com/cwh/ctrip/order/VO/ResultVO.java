package com.cwh.ctrip.order.VO;

import lombok.Data;

/**
 * Created by cwh
 * 2019-12-10 18:02
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
