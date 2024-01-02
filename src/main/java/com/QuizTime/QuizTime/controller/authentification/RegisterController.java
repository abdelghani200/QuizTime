package com.QuizTime.QuizTime.controller.authentification;
/*
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegisterController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
    @PostMapping
    public void registerUser(@RequestBody UserRegistrationRequest registrationRequest) {

        String hashedPassword = passwordEncoder.encode(registrationRequest.getPassword());

        User newUser = new User(registrationRequest.getUsername(), hashedPassword);
        userService.registerUser(newUser);
    }
}

 */
