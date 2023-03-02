package com.xueqian.config;

import jakarta.annotation.Resource;
import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "animal")
@ToString
public class ConfigProperties {
    @Resource
    private Cat cat;

}