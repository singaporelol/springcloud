package com.xueqian.eurekaservernewestversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerNewestversionApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerNewestversionApplication.class, args);
    }

}
