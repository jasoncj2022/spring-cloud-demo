package com.jason.cj.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;

/**
 * 只有正常请求的才会进来
 * @author jiancheng
 * @date 2022/7/8 12:59 PM
 */
@Component
@Order(value = Integer.MIN_VALUE)
public class AccessLogGlobalFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getPath().pathWithinApplication().value();
        InetSocketAddress remoteAddress = request.getRemoteAddress();
        return chain. //继续调用filter
                filter(exchange).
                //后置处理
                then(Mono.fromRunnable(() ->{
            ServerHttpResponse response = exchange.getResponse();
            HttpStatus httpStatus = response.getStatusCode();
            System.out.println(String.format("进入gateway，请求路径:%s,远程IP地址:%s,响应码:%s", path, remoteAddress, httpStatus));
        }));
    }
}
