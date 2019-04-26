package com.liqiye.rureka_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@SpringBootApplication
public class EurekaOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaOrderApplication.class, args);
    }

    // 解决RestTemplate没有注册到spring中管理的问题
    @Bean
    // @LoadBalanced注解能让RestTemplate在请求时拥有客户端负载均衡的能力ribbon
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

}

