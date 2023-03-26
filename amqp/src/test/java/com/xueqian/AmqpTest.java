package com.xueqian;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class AmqpTest {

    @Resource
    private RabbitTemplate rabbitTemplate;
    @Test
    public void testSimpleQueue(){
        // 队列名称
        String queueName = "simple.queue";
        // 消息
        String message = "hello, spring amqp!22";
        // 发送消息
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
