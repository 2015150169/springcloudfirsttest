package com.cwh.ctrip.product.utils;

import com.cwh.ctrip.product.VO.ResultVO;

/**
 * Created by cwh
 * 2019-12-09 22:53
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
