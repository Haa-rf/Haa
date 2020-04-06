package fun.haarf.blog.controller;

import fun.haarf.blog.entity.User;
import fun.haarf.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test(String username, String password) {
        return "hello";
    }

    @GetMapping("/authentication/session/invalid")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String sessionInvalid() {
        return "session expired";
    }

    @PostMapping("/authentication/register")
    public boolean register(User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/info")
    public User getInfo(User user) {
        return userService.getUser(user);
    }

    @PostMapping("/info")
    public boolean updateInfo(User user) {
        return userService.updateUser(user);
    }
}
