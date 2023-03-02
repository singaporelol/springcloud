package com.xueqian.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
@ConfigurationProperties(prefix = "person.xueqian")
// @Configuration("xueqian")
public class Binbin {
    private String name;
    private Integer age;
}
