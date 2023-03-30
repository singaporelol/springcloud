package com.ste.symphony.controller;

import com.ste.symphony.domain.MyMessage;
import com.ste.symphony.impl.MqttGateway;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MqttController {
    @Resource
    private MqttGateway mqttGateway;

    @PostMapping("/send")
    public String send(@RequestBody MyMessage myMessage) {
        // 发送消息到指定主题
        mqttGateway.sendToMqtt(myMessage.getTopic(), 1, myMessage.getContent());
        return "send topic: " + myMessage.getTopic()+ ", message : " + myMessage.getContent();
    }
}
