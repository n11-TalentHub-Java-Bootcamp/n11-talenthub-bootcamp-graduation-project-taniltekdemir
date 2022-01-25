package com.taniltekdemir.n11.bootcampgraduationproject.auth.controller;

import com.taniltekdemir.n11.bootcampgraduationproject.auth.dto.LoginRequestDto;
import com.taniltekdemir.n11.bootcampgraduationproject.auth.service.AuthenticationService;
import com.taniltekdemir.n11.bootcampgraduationproject.creditmanager.service.ManagerService;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserSaveEntityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final ManagerService managerService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto loginRequestDto){

        return authenticationService.login(loginRequestDto);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserSaveEntityDto userSaveEntityDto){

        UserDto userDto = authenticationService.registerCustomer(userSaveEntityDto);
        return ResponseEntity.ok(userDto);
    }

}

