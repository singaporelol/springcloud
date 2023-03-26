package com.xueqian;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AmqpFanoutTest {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testFanoutExchange(){
        // 队列名称
        String exchangeName = "itcast.fanout";
        // 消息
        String message = "hello, everyone!";
        // 发送消息
        rabbitTemplate.convertAndSend(exchangeName, "", message);

    }
}
