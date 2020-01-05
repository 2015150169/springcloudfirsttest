package com.cwh.ctrip.order.message;

import com.cwh.ctrip.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author:StreamReceiver
 * @DATE:2020/1/415:49
 **/
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {


    /**
    @StreamListener(StreamClient.INPUT)
    public void process(Object message) {
        System.out.println("StreamReceiver:" + message);
    }
    */

    /**
     * 接收orderDTO对象消息
     * @param message
     */
    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.OUTPUT2)
    public String process(OrderDTO message) {
        log.info("StreamReceiver:{}",message);
        System.out.println("StreamReceiver:" + message);
        return "received";
    }

    /**
     * 接收orderDTO对象消息
     * @param message
     */
    @StreamListener(StreamClient.INPUT2)
    public void processInput2(String message) {
        log.info("接收回调:{}",message);
        System.out.println("接收回调:" + message);
    }


}
