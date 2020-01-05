package com.cwh.ctrip.order.controller;

import com.cwh.ctrip.order.dto.OrderDTO;
import com.cwh.ctrip.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author:SendMessageController
 * @DATE:2020/1/415:51
 **/
@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    /*
    @GetMapping("/sendMessage")
    public void process() {
        String message = "now " + new Date();
        MessageChannel messageChannel = streamClient.output();
        messageChannel.send(MessageBuilder.withPayload(message).build());
    }*/

    /**
     * 发送orderDTO对象
     */
    @GetMapping("/sendMessage")
    public void process() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456");
        MessageChannel messageChannel = streamClient.output();
        messageChannel.send(MessageBuilder.withPayload(orderDTO).build());
    }

}
