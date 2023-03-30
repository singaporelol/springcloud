# 关于MQTT项目说明：

## 1. 项目简介

> 项目使用了MQTT协议，实现了一个简单的消息发布订阅系统
>
> 主要功能为： <br/>
> 1、使用MQTTbroker激发消息的转发 <br/>
>
> 例如：使用MQTT客户端，订阅了主题A，然后发送消息到主题A，这个时候，通过MQTT
> Application就可以捕捉到消息，对消息进行处理，然后选择将消息转发到另外一个MQTTbroker/或者其他什么地方
> MQTTbroker会将消息转发给订阅了主题A的客户端。 <br/>
> 2、通过post请求，将消息发送到MQTT broker，然后可以手动控制将消息，使用MQTT的方式发给另外的broker <br/>
>
>
>
>
## 这里使用了，两个MQTT broker，一个是mosquitto，一个是rabbitmq.
主要功能：<br/>
1、模拟发送的时候，先使用客户端，给rabbitmq发信息，被MQTT Application捕获到，
MQTT Application将信息转发到mosquitto，
mosquitto再将信息转发给订阅了主题A的客户端

2、通过postman,发送post请求，将信息发送到rabbitmq，被MQTT Application捕获到，
 MQTT在发送消息到其他地方。

通过配置Inbound和Outbound，可以实现消息的转发。
