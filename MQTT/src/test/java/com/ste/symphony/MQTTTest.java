package com.ste.symphony;

import com.ste.symphony.config.MqttConfig;
import com.ste.symphony.domain.MyMessage;
import com.ste.symphony.impl.MqttGateway;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootTest
public class MQTTTest {

    @Resource
    MqttConfig mqttConfig;

    @Resource
    MqttGateway mqttGateway;
    @Autowired
    ConfigurableApplicationContext configurableApplicationContext;

    @Test
    public void testSend(MyMessage myMessage) {
        myMessage.setContent("Hello World!");
        myMessage.setTopic("command");
        // mqttGateway.sendToMqtt(myMessage.getTopic(), 1, myMessage.getContent());
        // System.out.println("send topic: " + myMessage.getTopic()+ ", message : " + myMessage.getContent());
    }

    @Test
    public void testSendMQTT() {

        MqttGateway gateway = configurableApplicationContext.getBean(MqttGateway.class);
        gateway.sendToMqtt("command",1, "Hello World!");
        System.out.println("send topic: " + "command" + ", message : " + "Hello World!");

    }


}
