package com.liqiye.eureka_member2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaMember2Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMember2Application.class, args);
    }

}
