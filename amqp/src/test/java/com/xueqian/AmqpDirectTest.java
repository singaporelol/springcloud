package com.xueqian;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AmqpDirectTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testDirectExchange(){
        // 队列名称
        String exchangeName = "itcast.direct";
        // 消息
        String message = "红色警报！日本乱排核废水，导致海洋生物变异，惊现哥斯拉！";
        // 发送消息
        rabbitTemplate.convertAndSend(exchangeName, "red", message);

    }
}
