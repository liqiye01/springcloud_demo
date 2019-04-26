package com.liqiye.rureka_order.feign;


import com.liqiye.rureka_order.fallback.MemberFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

// fegin是采用 【接口+注解】 的形式实现的，远程rpc调用服务工具,里面已经集成ribbon负载均衡，默认开启

// @FeignClient注解指定调用哪个服务，里面传入参数name是要调用的服务的别名
// fallback属性可以指定使用feign远程调用服务，如果服务超时就会调用该类对应的方法，并返回（会被@HystrixCommand注解覆盖效果）
// 这个fallback属性 跟@HystrixCommand注解里的fallbackMethod指定的方法效果不一样，后者是直接熔断了，前者都会执行，相当于替代了本来要调用的服务
@FeignClient(name = "api-member",fallback = MemberFallback.class)
public interface MemberApiFeign {

    // fegin书写形式是以springmvc接口的形式（直接去要调用的服务的项目中去复制它的调用接口地址就行）
    @RequestMapping("/member")
    public String member();

}
