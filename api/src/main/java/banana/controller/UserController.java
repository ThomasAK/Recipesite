package banana.controller;

import banana.model.UserSignIn;
import banana.model.UserSignUp;
import banana.security.JwtTokenProvider;
import banana.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("signUp")
    public String signUp(@RequestBody UserSignUp userSignUp){
        return userService.signUp(userSignUp).getId();
    }

    @PostMapping("signIn")
    public String signIn(@RequestBody UserSignIn userSignIn, HttpServletResponse response){

        String token = userService.signIn(userSignIn);
        Cookie cookie = new Cookie("bananaToken",token);
        cookie.setHttpOnly(true);
        cookie.setMaxAge((int)JwtTokenProvider.validityInMilliseconds/1000);
        response.addCookie(cookie);
        return token;
    }

}
