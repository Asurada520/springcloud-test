package com.jade.serviceeureka.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class Gray2Filter extends ZuulFilter {

    private AtomicBoolean flag = new AtomicBoolean(true);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -5;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        // 获取指定的请求头信息，该头信息在浏览器提交请求时携带，用于区分该请求要被路由到哪个主机处理
//        String mark = request.getHeader("gray-mark");
//        // 默认将请求路由到running-host上
//        RibbonFilterContextHolder.getCurrentContext().add("host-mark", "running-host");
//        // 若mark的值不为空且值为enable，则将请求路由到gray-host，其它请求会路由到默认的running-host
//        if (!StringUtils.isEmpty(mark) && "enable".equals(mark)) {
//            RibbonFilterContextHolder.getCurrentContext().add("host-mark", "gray-host");
//        }

        if(flag.get()){
            // 默认将请求路由到running-host上
            RibbonFilterContextHolder.getCurrentContext().add("host-mark", "running-host");
            flag.set(false);
        }else {
            RibbonFilterContextHolder.getCurrentContext().add("host-mark", "gray-host");
            flag.set(true);
        }


        return null;
    }
}
