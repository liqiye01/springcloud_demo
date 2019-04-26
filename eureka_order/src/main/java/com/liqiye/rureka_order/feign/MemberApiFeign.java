package com.liqiye.rureka_order.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

// fegin是采用 【接口+注解】 的形式实现的，远程rpc调用服务工具,里面已经集成ribbon负载均衡，默认开启

// @FeignClient注解指定调用哪个服务，里面传入参数name是要调用的服务的别名
@FeignClient(name = "api-member")
public interface MemberApiFeign {

    // fegin书写形式是以springmvc接口的形式（直接去要调用的服务的项目中去复制它的调用接口地址就行）
    @RequestMapping("/member")
    public String member();

}
