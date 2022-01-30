package com.taniltekdemir.n11.bootcampgraduationproject.auth.controller;

import com.taniltekdemir.n11.bootcampgraduationproject.auth.dto.LoginRequestDto;
import com.taniltekdemir.n11.bootcampgraduationproject.auth.service.AuthenticationService;
import com.taniltekdemir.n11.bootcampgraduationproject.common.exception.CommonException;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto.ApplyExtendedSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto.ApplySaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;
import com.taniltekdemir.n11.bootcampgraduationproject.creditmanager.mapper.ManageMapper;
import com.taniltekdemir.n11.bootcampgraduationproject.creditmanager.service.ManagerService;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Authentication Controller", description = "Here we can login to get authorization, we can register user")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final ManagerService managerService;
    private final UserService userService;

    @PostMapping("/login")
    @Operation(summary = "You can add the token you receive as a login result to the authorize section without a bearer.")
    public Map<String, String> login(@RequestBody LoginRequestDto loginRequestDto){

        return authenticationService.login(loginRequestDto);
    }

    @PostMapping("/register")
    @Operation(summary = "You can register a user. You can use the password you set to login - authorization is not required")
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

