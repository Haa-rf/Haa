package fun.haarf.haa.gateway.util;

import fun.haarf.haa.common.constants.AuthConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;

/**
 * @Author: gourf
 * @Date: 2023-07-13  17:14
 * @Description: Auth相关工具类
 * @Version: 1.0
 */
@Slf4j
public class AuthUtil {

    public static String getTokenFromRequest(ServerHttpRequest request) {
        String token = getTokenFromHeader(request);
        if (StringUtils.isEmpty(token)) {
            token = getTokenFromCookie(request);
        }
        return token;
    }

    public static String getTokenFromHeader(ServerHttpRequest request) {
        String tokenStr = request.getHeaders().getFirst(AuthConstants.JWT_TOKEN_HEADER);
        log.info("get token from header({}) and value is : {}", AuthConstants.JWT_TOKEN_HEADER, tokenStr);
        if (StringUtils.isEmpty(tokenStr)) {
            return null;
        }
        return tokenStr.substring(AuthConstants.JWT_TOKEN_HEADER_PREFIX.length());
    }

    public static String getTokenFromCookie(ServerHttpRequest request) {
        HttpCookie tokenCookie = request.getCookies().getFirst(AuthConstants.JWT_TOKEN_COOKIE);
        if (tokenCookie == null) {
            return null;
        }
        String token = tokenCookie.getValue();
        log.info("get token from the cookie({}) and value is : {}", AuthConstants.JWT_TOKEN_COOKIE, token);
        return token;
    }
}
