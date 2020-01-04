package com.cwh.ctrip.order.message;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author:MqSenderTest
 * @DATE:2020/1/414:48
 **/
public class MqSenderTest extends OrderApplicationTests{

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send() {
        amqpTemplate.convertAndSend("myQueue","now " + new Date());
    }


    @Test
    public void sendComputer() {
        amqpTemplate.convertAndSend("myOrder","computer","now " + new Date());
    }

    @Test
    public void sendBComputer() {
        amqpTemplate.convertAndSend("myOrder","bComputer","now " + new Date());
    }

}
