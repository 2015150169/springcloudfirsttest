package com.cwh.ctrip.product.utils;

import com.cwh.ctrip.product.VO.ResultVO;


public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
