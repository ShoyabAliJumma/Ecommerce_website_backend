package com.ecommerce.demo.Controller;

import com.ecommerce.demo.Service.UserService;
import com.ecommerce.demo.dto.ResponseDto;
import com.ecommerce.demo.dto.user.SignUpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseDto signUp(@RequestBody SignUpDto signUpDto)
    {
        return userService.signUp(signUpDto);
    }
}
