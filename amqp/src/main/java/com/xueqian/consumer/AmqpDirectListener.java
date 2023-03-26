package com.xueqian.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AmqpDirectListener {


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "direct.queue1", durable = "true"),
            exchange = @Exchange(value = "itcast.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "blue"}
    ))
    public void listenDirectQueueMessages1(String message) {
        System.out.println("DirectQueue1 接收到消息：" + message);
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "direct.queue2", durable = "true"),
            exchange = @Exchange(value = "itcast.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "yellow"}
    ))
    public void listenDirectQueueMessages2(String message) {
        System.out.println("DirectQueue2 接收到消息：" + message);
    }

}
