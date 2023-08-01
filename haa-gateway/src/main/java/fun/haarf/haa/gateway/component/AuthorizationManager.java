package fun.haarf.haa.gateway.component;

import cn.hutool.core.collection.CollUtil;
import fun.haarf.haa.gateway.config.IgnoreUrlsConfig;
import fun.haarf.haa.gateway.util.AuthUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @Author: gourf
 * @Date: 2023-07-13  16:48
 * @Description: 判断用户是否有权限访问对应资源
 * @Version: 1.0
 */
@Component
@Slf4j
public class AuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {

    @Resource
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> authentication, AuthorizationContext authorizationContext) {
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();
        if (request.getMethod() == HttpMethod.OPTIONS) {
            return Mono.just(new AuthorizationDecision(true));
        }
        //放行不需要认证的uri
        if (CollUtil.isNotEmpty(ignoreUrlsConfig.getUrls())) {
            PathMatcher pathMatcher = new AntPathMatcher();
            for (String ignoreUrl : ignoreUrlsConfig.getUrls()) {
                if (pathMatcher.match(ignoreUrl, request.getURI().getPath())) {
                    return Mono.just(new AuthorizationDecision(true));
                }
            }
        }
        String token = AuthUtil.getTokenFromRequest(request);
        if (StringUtils.isEmpty(token)) {
            return Mono.just(new AuthorizationDecision(false));
        }

        return authentication
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                //todo 自定义判断
                .any(Objects::nonNull)
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false));
    }
}
