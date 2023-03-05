package com.xueqian.orderservice.service;

import com.xueqian.feign.clients.UserClient;
import com.xueqian.feign.pojo.User;
import com.xueqian.orderservice.mapper.OrderMapper;
import com.xueqian.orderservice.pojo.Order;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private RestTemplate restTemplate;
    //使用Feign，拿到容器内的Userclient对象
    @Resource
    private UserClient userClient;

    /**
     * 使用Feign调用，替代restTemplate(不优雅)
     * @param orderId
     * @return
     */
    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // String url="http://userservice/user/" +order.getUserId();
        // User user = restTemplate.getForObject(url, User.class);
        //2.利用Feign发起http请求，查询用户
        User user = userClient.findById(order.getUserId());
        order.setUser(user);
        // 4.返回
        return order;
    }

    /*
    * 使用nacos，eureka调用下面的方法
    * */
//     public Order queryOrderById(Long orderId) {
//         // 1.查询订单
//         Order order = orderMapper.findById(orderId);
// //        String url="http://localhost:8081/user/" +order.getUserId();
//         String url="http://userservice/user/" +order.getUserId();

//         User user = restTemplate.getForObject(url, User.class);
//         order.setUser(user);
//         // 4.返回
//         return order;
//     }
}
