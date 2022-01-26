package com.taniltekdemir.n11.bootcampgraduationproject.auth.controller;

import com.taniltekdemir.n11.bootcampgraduationproject.auth.dto.LoginRequestDto;
import com.taniltekdemir.n11.bootcampgraduationproject.auth.service.AuthenticationService;
import com.taniltekdemir.n11.bootcampgraduationproject.creditmanager.service.ManagerService;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserSaveEntityDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final ManagerService managerService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequestDto loginRequestDto){

        return authenticationService.login(loginRequestDto);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserSaveEntityDto userSaveEntityDto){
        try {
            UserDto userDto = authenticationService.registerCustomer(userSaveEntityDto);
            return ResponseEntity.ok(userDto);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

