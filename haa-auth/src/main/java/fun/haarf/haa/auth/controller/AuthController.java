package fun.haarf.haa.auth.controller;

import fun.haarf.haa.common.domain.response.StandardResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自定义Oauth2获取令牌接口
 * Created by macro on 2020/7/17.
 */
@RestController
//@Api(tags = "AuthController", description = "认证中心登录认证")
@RequestMapping("/oauth")
public class AuthController {

//    @Autowired
//    private TokenEndpoint tokenEndpoint;
//
//    @ApiOperation("Oauth2获取token")
//    @RequestMapping(value = "/token", method = RequestMethod.POST)
//    public CommonResult<Oauth2TokenDto> postAccessToken(HttpServletRequest request,
//                                                        @ApiParam("授权模式") @RequestParam String grant_type,
//                                                        @ApiParam("Oauth2客户端ID") @RequestParam String client_id,
//                                                        @ApiParam("Oauth2客户端秘钥") @RequestParam String client_secret,
//                                                        @ApiParam("刷新token") @RequestParam(required = false) String refresh_token,
//                                                        @ApiParam("登录用户名") @RequestParam(required = false) String username,
//                                                        @ApiParam("登录密码") @RequestParam(required = false) String password) throws HttpRequestMethodNotSupportedException {
//        Map<String, String> parameters = new HashMap<>();
//        parameters.put("grant_type",grant_type);
//        parameters.put("client_id",client_id);
//        parameters.put("client_secret",client_secret);
//        parameters.putIfAbsent("refresh_token",refresh_token);
//        parameters.putIfAbsent("username",username);
//        parameters.putIfAbsent("password",password);
//        OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(request.getUserPrincipal(), parameters).getBody();
//        Oauth2TokenDto oauth2TokenDto = Oauth2TokenDto.builder()
//                .token(oAuth2AccessToken.getValue())
//                .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
//                .expiresIn(oAuth2AccessToken.getExpiresIn())
//                .tokenHead(AuthConstant.JWT_TOKEN_PREFIX).build();
//
//        return CommonResult.success(oauth2TokenDto);
//    }
    @GetMapping("/ping")
    public StandardResult<String> ping(){
        return StandardResult.success("pong");
    }
}
