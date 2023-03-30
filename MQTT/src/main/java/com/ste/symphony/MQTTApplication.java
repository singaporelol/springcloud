package com.ste.symphony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.integration.annotation.IntegrationComponentScan;

@SpringBootApplication
@IntegrationComponentScan
public class MQTTApplication {
        public static void main(String[] args) {
            ConfigurableApplicationContext run = SpringApplication.run(MQTTApplication.class, args);
            System.out.println("MQTTApplication started.");
        }
}
