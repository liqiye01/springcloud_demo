package com.liqiye.rureka_order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqiye
 * @description 测试读取分布式配置中心中的配置文件
 * @date 2019/4/25
 */

//开启手动刷新配置中心的配置
//在Git修改了配置文件后，要手动用postman用post请求http://ip:该项目端口/actuator/refresh 才能生效
@RefreshScope
@RestController
public class ConfigController {

    @Value("${name}")
    private String name;

    @RequestMapping("/config")
    public String config(){
        return name;
    }

}
