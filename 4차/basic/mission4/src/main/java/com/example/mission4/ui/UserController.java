package com.example.mission4.ui;

import com.example.mission4.dto.UserDto;
import com.example.mission4.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "login-form";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signup-form";
    }

    @PostMapping("/signup")
    public String signUpPost(
            @ModelAttribute UserDto userDto
    ) {
        userService.createUser(userDto);
        return "redirect:/home";
    }
}
