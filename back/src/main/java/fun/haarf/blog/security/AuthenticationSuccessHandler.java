package fun.haarf.blog.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import fun.haarf.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {

    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //update last-login-date
        UserDetails userDetail = (UserDetails) authentication.getPrincipal();
        userService.updateLastLoginDate(userDetail.getUsername(), System.currentTimeMillis());
        httpServletResponse.setContentType("application/json;charset=utf-8");
        ResponseVo responseVo = new ResponseVo();
        responseVo.setResult("success");
        responseVo.setType("login");
        httpServletResponse.getWriter().write(mapper.writeValueAsString(responseVo));
    }
}
