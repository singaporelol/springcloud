package com.xueqian.userservice.web;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.xueqian.userservice.config.ConfigProperties;
import com.xueqian.userservice.pojo.User;
import com.xueqian.userservice.service.UserService;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Slf4j
@RestController
@RequestMapping("/user")
@EnableDiscoveryClient
@RefreshScope
public class UserController {

    @Resource
    private UserService userService;
//    @Resource
//    private ConfigProperties configProperties;

    // @NacosValue()
    @Value("${pattern.dateformat}")
    private String dateformat;

    // @Value("${pattern.envSharedValue}")
    // private String envSharedValue;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    // @RequestHeader(value = "Truth", required = false) String truth,用于测试Gateway的过滤器，可以删掉
    public User queryById(@RequestHeader(value = "Truth", required = false) String truth,
                          @PathVariable("id") Long id) {
        System.out.println(truth);
        return userService.queryById(id);
    }

    //    @GetMapping("/now")
//    public String now(){
//        String dateformat = configProperties.getDateformat();
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat));
//    }
    @GetMapping("/now")
    public String now() {
        // System.out.println(envSharedValue);
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat));
    }

}