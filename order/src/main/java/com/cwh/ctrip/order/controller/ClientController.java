package com.cwh.ctrip.order.controller;

import com.cwh.ctrip.order.client.ProductClient;
import com.cwh.ctrip.order.dataobject.ProductInfo;
import com.cwh.ctrip.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        //1 第一种方式(直接使用restTemplate,url写死)

        //2 第二种方式根据loadBalanceClient通过应用名获取url,然后再使用restTemplate
        RestTemplate restTemplate2 = new RestTemplate();
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort()) + "/msg";
        String response2 = restTemplate2.getForObject(url,String.class);
        //3 第三种方式
        String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);
        return response;
    }

    @GetMapping("/getProductFeignMsg")
    public String getProductFeignMsg() {
        String response = productClient.productMsg();
        return response;
    }

    @GetMapping("/getListForOrder")
    public String getListForOrder() {
        List<ProductInfo> productInfoList =  productClient.listForOrder(Arrays.asList("157875227953464068"));
        log.info("repsonse={}",productInfoList);
        String response = "ok";
        return response;
    }

    @GetMapping("/decreaseProductStock")
    public String decreaseProductStock() {
        productClient.decreaseStock(Arrays.asList(new CartDTO("157875227953464068",3)));
        String response = "ok";
        return response;
    }

}
