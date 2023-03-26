package com.xueqian.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AmqpListener {
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessages(String message) {
        System.out.println("接收到消息：" + message);
    }
}
