package com.xueqian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Main.class, args);

        // ConfigProperties bean = run.getBean(ConfigProperties.class);
        // System.out.println(bean);
        // String name = bean.getCat().getName();
        // System.out.println(name);
        // xueqian xq = run.getBean(xueqian.class);
        // System.out.println(xq.getName());
        // System.out.println(xq.getAge());

    }
}