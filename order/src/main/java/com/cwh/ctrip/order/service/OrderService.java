package com.cwh.ctrip.order.service;


import com.cwh.ctrip.order.dto.OrderDTO;


public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
