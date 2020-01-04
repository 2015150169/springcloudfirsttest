package com.cwh.ctrip.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author:MqReceiver
 * @DATE:2020/1/414:45
 **/
@Slf4j
@Component
public class MqReceiver {

    //1. @RabbitListener(queues = "myQueue")
    //2. 自动创建队列@RabbitListener(queuesToDeclare = @Queue("myQueue"))
    //3. 自动创建，Exchange和Queue绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message) {
        log.info("MyReceiver:{}",message);
    }

    /**
     * 模拟两个服务，分组
     * computer服务
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")
    ))
    public void processComputer(String message) {
        log.info("My Computer Receiver:{}",message);
    }


    /**
     * 模拟两个服务，分组
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "bComputer",
            value = @Queue("computerOrder")
    ))
    public void processBComputer(String message) {
        log.info("My B ComputerReceiver:{}",message);
    }

}
