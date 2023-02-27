package com.xueqian.orderservice.service;

import com.xueqian.orderservice.mapper.OrderMapper;
import com.xueqian.orderservice.pojo.Order;
import com.xueqian.orderservice.pojo.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
//        String url="http://localhost:8081/user/" +order.getUserId();
        String url="http://userservice/user/" +order.getUserId();

        User user = restTemplate.getForObject(url, User.class);
        order.setUser(user);
        // 4.返回
        return order;
    }
}
