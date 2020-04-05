package fun.haarf.blog.controller;

import fun.haarf.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test(String username, String password) {
        return "hello";
    }

    @GetMapping("/index")
    public Object index() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

}
