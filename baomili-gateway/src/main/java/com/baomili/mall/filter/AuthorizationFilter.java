package com.baomili.mall.filter;

import com.baomili.mall.modules.common.constant.ResultCode;
import com.baomili.mall.properties.AuthProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.internal.util.privilegedactions.GetResolvedMemberMethods;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;
import java.net.URI;
import java.security.PublicKey;
import java.util.Map;

/**
 * 认证过滤器,根据url判断用户请求是要经过认证 才能访问
 */
@Slf4j
@Component
@EnableConfigurationProperties(value = AuthProperties.class)
public class AuthorizationFilter implements GlobalFilter,Ordered,InitializingBean {

    @Autowired
    private AuthProperties authProperties;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String url = exchange.getRequest().getURI().getPath();
        // 1.不需要认证的URL
        if (!shouldSkip(url)) {
            throw new RuntimeException(ResultCode.UNAUTHORIZED.getMessage());
        } else {
            return chain.filter(exchange);
        }
        // 2.需要认证的URL
        // ①解析请求头
//        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
        // ②判断Authorization请求头是否为空
//        if (StringUtils.isBlank(authHeader)) {
//            log.error("请求头为空");
//            throw new RuntimeException(ResultCode.UNAUTHORIZED.getMessage());
//        }
        // ③校验Authorization请求头中的jwt是否合法

        // ④解析jwt，将用户信息存储到请求头
//        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    private boolean shouldSkip(String url) {
        PathMatcher pathMatcher = new AntPathMatcher();
        for (String shouldSkipUrl : authProperties.getShouldSkipUrls()) {
            if (pathMatcher.match(shouldSkipUrl, url)) {
                return true;
            }
        }
        return false;
    }
}
