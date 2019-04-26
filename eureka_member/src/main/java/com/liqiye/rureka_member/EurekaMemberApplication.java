package com.liqiye.rureka_member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMemberApplication.class, args);
    }

}
