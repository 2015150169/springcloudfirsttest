package com.cwh.ctrip.order.utils;

import com.cwh.ctrip.order.VO.ResultVO;

/**
 * Created by cwh
 * 2019-12-10 18:03
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("success");
        resultVO.setData(object);
        return resultVO;
    }
}
