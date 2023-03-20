package com.xueqian.gateway.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.xueqian.gateway.function.RequestBodyRewrite;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

@Configuration
public class SptelFilterConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder, ObjectMapper objectMapper) {
        return builder.routes()
                .route("rewrite_request_obj",
                        r -> r.path("/test")
                                .filters(f -> f
                                        .modifyRequestBody(String.class,String.class, new RequestBodyRewrite(objectMapper))
                                )
                                .uri("http://localhost:3101")
                ).build();



    }

}
