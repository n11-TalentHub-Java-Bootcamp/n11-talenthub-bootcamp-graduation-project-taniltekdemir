package com.taniltekdemir.n11.bootcampgraduationproject.auth.service;

import com.taniltekdemir.n11.bootcampgraduationproject.auth.dto.UserRequestDto;
import com.taniltekdemir.n11.bootcampgraduationproject.auth.security.EnumJwtConstant;
import com.taniltekdemir.n11.bootcampgraduationproject.auth.security.JwtTokenGenerator;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
import com.taniltekdemir.n11.bootcampgraduationproject.user.service.entityService.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserEntityService userEntityService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;

    public String login(UserRequestDto userRequestDto){

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken
                (userRequestDto.getUsername(), userRequestDto.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenGenerator.generateJwtToken(authentication);

        return EnumJwtConstant.BEARER.getConstant() + token;
    }

    public void validateUserRequest(String username) {

        User user = userEntityService.findByTckn(username);

        if (user != null){
            throw new RuntimeException("TCKN already in use");
        }
    }
}
