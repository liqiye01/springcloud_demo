package com.liqiye.rureka_order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author liqiye
 * @description
 * @date 2019/4/20
 */
@RestController
public class OrderController {

    // RestTemplate是由springboot web组件提供的默认整合ribbon负载均衡器
    @Autowired
    private RestTemplate restTemplate;

    // 在springcloud有两种方式调用服务 restTemplate 和 feign
    // 这里用restTemplate（一般实际开发基本都用feign），restTemplate底层是采用httpClient

    // 订单功能调用会员服务
    // @HystrixCommand注解是hystrix解决服务雪崩效应，服务熔断和服务降级，降级的方法用属性fallbackMethod指定
    // 加了@HystrixCommand这个注解默认开启线程池隔离（服务隔离），就是该接口单独开了一个线程池，它请求过多阻塞了其他接口还能访问
    @HystrixCommand(fallbackMethod = "hystrixFallBack")
    @RequestMapping("/order")
    public String order(){
        // 有两种方式，可以直接调用固定的域名，也可以使用别名（就是注册中心的别名）
        // （如果使用别名必须要调用依赖ribbon负载均衡器，在注入RestTemplate bean的地方使用注解@LoadBalanced，使用ribbon后固定域名失效）
        String url1 = "http://api-member/member";
        // String url2 = "http://localhost:8762/member";
        String result= restTemplate.getForObject(url1, String.class);
        System.out.println("线程池名称："+Thread.currentThread().getName());
        return "restTemplate方式 订单功能调用会员服务:"+result;
    }

    public String hystrixFallBack(){
        return "服务繁忙。请销后重试！";
    }

    @RequestMapping("/orderInfo")
    public String orderInfo(){
        System.out.println("线程池名称："+Thread.currentThread().getName());
        return "orderInfo";
    }

}
