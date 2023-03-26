package com.xueqian.consumer;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpMessageConvertListener {
    @Bean
    public Queue objectQueue(){
        return new Queue("object.queue");
    }
}
