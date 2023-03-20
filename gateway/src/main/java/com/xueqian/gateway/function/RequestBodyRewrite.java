package com.xueqian.gateway.function;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.factory.rewrite.RewriteFunction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

@Slf4j
public class RequestBodyRewrite implements RewriteFunction<String, String> {
    private ObjectMapper objectMapper;
    public RequestBodyRewrite(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Publisher<String> apply(ServerWebExchange exchange, String body) {
        try {
            Map<String, Object> map = objectMapper.readValue(body, Map.class);
            // String hobby = (String) map.get("hobby");

            // 得到nanme后写入map
            map.put("hobby", "sleeping");

            return Mono.just(objectMapper.writeValueAsString(map));
        } catch (Exception ex) {
            return Mono.error(new Exception("1. json process fail", ex));
        }
    }
}
