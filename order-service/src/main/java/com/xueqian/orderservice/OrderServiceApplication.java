package com.xueqian.orderservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan(basePackages = {"com.xueqian.orderservice.mapper"})
@EnableDiscoveryClient
// @EnableFeignClients(defaultConfiguration = DefaultFeignConfiguration.class)
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(OrderServiceApplication.class, args);

    }

    @Bean
    @LoadBalanced

    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public IRule randomRule(){
//        return new RandomRule();
//    }

}
