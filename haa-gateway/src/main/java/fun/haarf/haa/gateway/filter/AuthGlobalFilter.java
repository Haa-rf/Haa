package fun.haarf.haa.gateway.filter;

import com.nimbusds.jose.JWSObject;
import fun.haarf.haa.common.constants.AuthConstants;
import fun.haarf.haa.gateway.util.AuthUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.text.ParseException;

/**
 * @Author: gourf
 * @Date: 2023-07-13  16:26
 * @Description: auth全局过滤器
 * @Version: 1.0
 */
@Component
@Slf4j
public class AuthGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = AuthUtil.getTokenFromRequest(exchange.getRequest());
        if (StringUtils.isEmpty(token)) {
            return chain.filter(exchange);
        }
        try {
            JWSObject jwsObject = JWSObject.parse(token);
            String userInfo = jwsObject.getPayload().toString();
            log.info("AuthGlobalFilter.filter user:{}", userInfo);
            exchange.getRequest().mutate().header(AuthConstants.USER_INFO_HEADER, userInfo).build();
        } catch (ParseException e) {
            log.error("JWSObject parse error", e);
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
