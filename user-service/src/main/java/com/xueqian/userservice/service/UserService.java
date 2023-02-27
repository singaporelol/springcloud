package com.xueqian.userservice.service;

import com.xueqian.userservice.mapper.UserMapper;
import com.xueqian.userservice.pojo.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public User queryById(Long id) {
        return userMapper.findById(id);
    }
}
