package com.xueqian.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AmqpWorkQueueListener {

    @RabbitListener(queues = "work.queue")
    public void listenWorkQueueMessages1(String message) throws InterruptedException {
        System.out.println("WorkQueueMessages1 接收到消息：" + message);
        Thread.sleep(20);
    }
    @RabbitListener(queues = "work.queue")
    public void listenWorkQueueMessages2(String message) throws InterruptedException {
        System.out.println("WorkQueueMessages2 接收到消息：" + message);
        Thread.sleep(200);
    }
}
