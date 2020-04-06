package fun.haarf.blog.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SessionExpiredStrategy implements SessionInformationExpiredStrategy {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
        HttpServletResponse response = sessionInformationExpiredEvent.getResponse();
        response.setContentType("application/json;charset=utf-8");
        ResponseVo responseVo = new ResponseVo();
        responseVo.setResult("invalid");
        responseVo.setType("session");
        responseVo.setMessage("Warning: your account has been logged in to another device");
        response.getWriter().write(mapper.writeValueAsString(responseVo));
    }
}
