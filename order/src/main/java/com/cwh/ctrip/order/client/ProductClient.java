package com.cwh.ctrip.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();

}
