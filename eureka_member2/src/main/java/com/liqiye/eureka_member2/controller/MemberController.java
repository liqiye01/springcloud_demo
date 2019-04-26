package com.liqiye.eureka_member2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqiye
 * @description
 * @date 2019/4/20
 */
@RestController
public class MemberController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/member")
    public String member(){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "会员服务，端口号："+port;
    }

}
