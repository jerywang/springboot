/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package zuul;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 登录过滤器
 * 记得类上加Component注解
 */
@Component
public class LoginFilter extends ZuulFilter {

    /**
     * 过滤器类型，前置过滤器
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 过滤器顺序，越小越先执行
     */
    @Override
    public int filterOrder() {
        return 4;
    }

    /**
     * 过滤器是否生效
     * 返回true代表需要权限校验，false代表不需要用户校验即可访问
     */
    public boolean shouldFilter() {
        //共享RequestContext，上下文对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //需要权限校验URL
        if ("/service-hi/demo/hi".equalsIgnoreCase(request.getRequestURI())) {
            return true;
        }
        return false;
    }

    /**
     * 只有上面shouldFilter()返回true的时候，才会进入到该方法
     */
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)) {
            // 过滤该请求，不对其进行路由
            requestContext.setSendZuulResponse(false);
            //返回错误代码
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            requestContext.set("isSuccess", false);
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseBody("{\"code\":400}");
            requestContext.getResponse().setContentType("application/json; charset=utf-8");
            return null;
        }
        return null;
    }
}