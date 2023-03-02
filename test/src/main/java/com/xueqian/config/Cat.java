package com.xueqian.config;


import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ToString
@EnableConfigurationProperties
public class Cat {
    private String name;
    private Integer age;

}
