import com.rabbitmq.client.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class RabbitMQPublisherTest {
    @Test
    public void testSendMessage() throws IOException, TimeoutException {
        // 1、创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 2、设置参数
        connectionFactory.setHost("192.168.2.100");// ip  默认值 localhost
        connectionFactory.setPort(5672);// 端口  默认值 5672
        connectionFactory.setVirtualHost("/");// 虚拟机 默认值/
        connectionFactory.setUsername("itcast");// 用户名
        connectionFactory.setPassword("123321");// 密码
        // 3、创建连接 Connection
        Connection connection = connectionFactory.newConnection();
        // 4、创建Channel
        Channel channel = connection.createChannel();
        // 5、创建队列 Queue
        String queueName = "simple.queue";
        channel.queueDeclare(queueName, true, false, false, null);
        // 6、发送消息
        String message = "hello rabbitmq";
        channel.basicPublish("", queueName, null, message.getBytes());
        System.out.println("消息发送成功：【" +message + "】");
        // 7、释放资源
        channel.close();
        connection.close();

    }


    @Test
    public void testReceiveMessage() throws IOException, TimeoutException {
        // 1.建立连接
        ConnectionFactory factory = new ConnectionFactory();
        // 1.1.设置连接参数，分别是：主机名、端口号、vhost、用户名、密码
        factory.setHost("192.168.2.100");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("itcast");
        factory.setPassword("123321");
        // 1.2.建立连接
        Connection connection = factory.newConnection();

        // 2.创建通道Channel
        Channel channel = connection.createChannel();
        // 3.创建队列
        String queueName = "simple.queue";
        channel.queueDeclare(queueName, true, false, false, null);

        // 4.订阅消息

        channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("接收到消息：" + new String(body));
            }
        });
        System.out.println("等待接收消息。。。。");

    }
}
