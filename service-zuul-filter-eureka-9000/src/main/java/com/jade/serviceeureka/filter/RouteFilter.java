package com.jade.serviceeureka.filter;

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
        HttpServletRequest request = context.getRequest();
        String user = request.getParameter("user");
        String uri = request.getRequestURI();
        if(uri.contains("/zuul8080") && StringUtils.isEmpty(user)){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
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
