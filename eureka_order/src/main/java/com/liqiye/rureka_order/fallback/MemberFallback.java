package com.liqiye.rureka_order.fallback;

import com.liqiye.rureka_order.feign.MemberApiFeign;
import org.springframework.stereotype.Component;

/**
 * @author liqiye
 * @description 调用会员服务的服务降级回调方法
 * @date 2019/4/26
 */
@Component
public class MemberFallback implements MemberApiFeign {

    @Override
    public String member() {
        return "会员服务系统繁忙，请稍后重试！";
    }
}
