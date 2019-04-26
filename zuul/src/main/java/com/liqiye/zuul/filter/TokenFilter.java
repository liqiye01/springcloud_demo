package com.liqiye.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liqiye
 * @description 网关拦截器，拦截所有走网关的请求，且没有传入userToken的请求
 * @date 2019/4/26
 */

// 只要启动了网关项目，就会自动加载这个继承了ZuulFilter的类，自动实现拦截的功能

@Component
public class TokenFilter extends ZuulFilter {

    // 过滤类型 pre 表示在请求之前拦截
    @Override
    public String filterType() {
        return "pre";
    }

    // 过滤器执行顺序，当一个请求在同一个阶段的时候存在多个过滤器，执行的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    // 判断过滤器是否生效
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //拦截的逻辑代码
    @Override
    public Object run() throws ZuulException {
        // 拦截所有服务接口，判断有没有usertoken参数
        // 调用zuul内置对象获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 获取request
        HttpServletRequest request = currentContext.getRequest();
        // 获取usertoken
        String usertoken = request.getParameter("usertoken");
        if(StringUtils.isEmpty(usertoken)){
            // 不会继续执行，网关直接响应给客户端
            currentContext.setSendZuulResponse(false);
            // 返回一个提示
            currentContext.setResponseBody("usertoken is null");
            currentContext.setResponseStatusCode(401);
            return null;
        }
        // 放行，调用其他接口
        return null;
    }
}
