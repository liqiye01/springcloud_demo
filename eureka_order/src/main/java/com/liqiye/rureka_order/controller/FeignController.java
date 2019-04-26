package com.liqiye.rureka_order.controller;

import com.liqiye.rureka_order.feign.MemberApiFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqiye
 * @description 测试fegin
 * @date 2019/4/21
 */
@RestController
public class FeignController {

    // 将要使用的feign注入进来，用于远程调用服务的
    @Autowired
    private MemberApiFeign memberApiFeign;

    @HystrixCommand(fallbackMethod = "hystrixFallBack")
    @RequestMapping("/feign")
    public String feign(){
        String result = memberApiFeign.member();
        return "feign 订单服务调用会员服务："+result;
    }

    public String hystrixFallBack(){
        return "服务繁忙。请销后重试！";
    }


}
