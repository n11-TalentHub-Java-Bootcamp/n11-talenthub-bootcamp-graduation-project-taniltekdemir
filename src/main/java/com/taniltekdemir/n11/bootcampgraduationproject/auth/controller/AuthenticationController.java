package com.taniltekdemir.n11.bootcampgraduationproject.auth.controller;

import com.taniltekdemir.n11.bootcampgraduationproject.auth.dto.UserRequestDto;
import com.taniltekdemir.n11.bootcampgraduationproject.auth.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public String login(@RequestBody UserRequestDto userRequestDto){

        return authenticationService.login(userRequestDto);
    }
}
