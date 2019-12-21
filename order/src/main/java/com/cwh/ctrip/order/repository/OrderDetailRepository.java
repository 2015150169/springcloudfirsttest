package com.cwh.ctrip.order.repository;

import com.cwh.ctrip.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {



}
