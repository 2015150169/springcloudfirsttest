package com.cwh.ctrip.order.service;

import com.cwh.ctrip.order.dto.OrderDTO;

/**
 * Created by cwh
 * 2019-12-10 16:39
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
