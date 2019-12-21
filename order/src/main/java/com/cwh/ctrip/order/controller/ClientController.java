package com.cwh.ctrip.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        //1 第一种方式(直接使用restTemplate,url写死)

        //3 第三种方式
        String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);
        return response;
    }


}
