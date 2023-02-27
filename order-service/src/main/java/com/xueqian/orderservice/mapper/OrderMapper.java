package com.xueqian.orderservice.mapper;

import com.xueqian.orderservice.pojo.Order;


public interface OrderMapper {
    Order findById(Long id);
}
