package com.xueqian.controller;

import com.xueqian.config.Binbin;
import com.xueqian.config.Cat;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "")
public class test {

    @Autowired
    private Environment environment;
    // @Resource
    // private xueqian xq;
    @Autowired
    private Cat cat;
    @RequestMapping("/hello")
    public String Hell(){
        // System.out.println(xq.getName());
        // System.out.println(xueqian.getAge());
        // System.out.println(cat.getName());
        // System.out.println(environment.getProperty("person.xueqian.age"));
        return  "hello";
    }
}
