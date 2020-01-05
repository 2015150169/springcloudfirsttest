package com.cwh.ctrip.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * cwh
 */
@Component
public interface StreamClient {

    /**
     * 关键点 Input和Output不能重名 重名会报错导致消息丢失
     * 而且需要将Input和Output指向同一个topic，在配置文件中配置
     * spring:
     *     stream:
     *       bindings:
     *         myMessage:
     *           group: order
     *         myMessageInput:
     *           destination: myMessage
     *         myMessageOutPut:
     *           destination: myMessage
     */
    String INPUT = "myMessageInput";
    String OUTPUT = "myMessageOutPut";

    String INPUT2 = "myMessageInput2";
    String OUTPUT2 = "myMessageOutPut2";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();

    @Input(StreamClient.INPUT2)
    SubscribableChannel input2();

    @Output(StreamClient.OUTPUT2)
    MessageChannel output2();

}
