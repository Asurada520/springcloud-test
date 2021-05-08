package com.jade.serviceeureka.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class RouteFilter extends ZuulFilter {

    private static final RateLimiter RATE_LIMITER = RateLimiter.create(2);

    // 指定路由之前 进行过滤
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
//        在系统最小值 -3 前执行
        return -5;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();

        boolean tryAcquire = RATE_LIMITER.tryAcquire();
        if(!tryAcquire){
            log.warn("访问量超载");
//            指定当前请求未通过zuul过滤
            context.setSendZuulResponse(false);
//            向客户端响应 "请求数量太多"， 429
            context.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
            return false;
        }

        return true;
    }

    @Override
    public Object run() throws ZuulException {
//        请求通过过滤后的逻辑
        log.info("请求通过过滤");
        return null;
    }
}
