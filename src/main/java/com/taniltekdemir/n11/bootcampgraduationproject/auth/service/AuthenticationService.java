package com.taniltekdemir.n11.bootcampgraduationproject.auth.service;

import com.taniltekdemir.n11.bootcampgraduationproject.auth.dto.LoginRequestDto;
import com.taniltekdemir.n11.bootcampgraduationproject.auth.security.EnumJwtConstant;
import com.taniltekdemir.n11.bootcampgraduationproject.auth.security.JwtTokenGenerator;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.service.UserService;
import com.taniltekdemir.n11.bootcampgraduationproject.user.service.entityService.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationService {

    private final UserEntityService userEntityService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerator jwtTokenGenerator;
    private final UserService userService;


    public String login(LoginRequestDto loginRequestDto){

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken
                (loginRequestDto.getUsername(), loginRequestDto.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenGenerator.generateJwtToken(authentication);

        return EnumJwtConstant.BEARER.getConstant() + token;
    }

    public UserDto registerCustomer(UserSaveEntityDto userSaveEntityDto) {
        return userService.save(userSaveEntityDto);
    }
}
