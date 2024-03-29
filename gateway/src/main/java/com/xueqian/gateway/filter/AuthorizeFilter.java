package com.xueqian.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1、获取请求参数
        MultiValueMap<String, String> params = exchange.getRequest().getQueryParams();
        // 2、获取authorization参数
        String auth = params.getFirst("authorization");
        // 3、校验
        if ("admin".equals(auth)) {
            // 放行
            return chain.filter(exchange);
        }
        // 4、拦截
        //     4.1、禁止访问
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        //     4.2、结束处理
        return  exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
        return -1;
    }

}
