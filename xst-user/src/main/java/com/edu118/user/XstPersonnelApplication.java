package com.edu118.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class XstPersonnelApplication {
    public static void main(String[] args) {
        SpringApplication.run(XstPersonnelApplication.class, args);
    }
}
