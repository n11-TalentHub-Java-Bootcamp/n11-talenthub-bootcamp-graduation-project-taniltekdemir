package com.taniltekdemir.n11.bootcampgraduationproject.auth.service;

import com.taniltekdemir.n11.bootcampgraduationproject.auth.dto.LoginRequestDto;
import com.taniltekdemir.n11.bootcampgraduationproject.auth.security.EnumJwtConstant;
import com.taniltekdemir.n11.bootcampgraduationproject.auth.security.JwtTokenGenerator;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
import com.taniltekdemir.n11.bootcampgraduationproject.user.service.UserService;
import com.taniltekdemir.n11.bootcampgraduationproject.user.service.entityService.UserEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationService {

    private final UserEntityService userEntityService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerator jwtTokenGenerator;
    private final UserService userService;


    public Map<String, String> login(LoginRequestDto loginRequestDto){

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken
                (loginRequestDto.getUsername(), loginRequestDto.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenGenerator.generateJwtToken(authentication);

        User user = userEntityService.findByTckn(loginRequestDto.getUsername());//burada repoya atılan sorguda dönen veri zaten sadece id olacak şekilde ayarlanabilir
        Long userId = user.getId();

        Map<String, String> response = new HashMap<>();
        response.put("token", EnumJwtConstant.BEARER.getConstant() + token);
        response.put("currentUserId", userId.toString());
        response.put("currentUserName", user.getName());
        log.info("{} tckn li kullanıcı giriş yaptı", user.getTckn());
        return response;
    }

    public UserDto registerCustomer(UserSaveEntityDto userSaveEntityDto) {
        return userService.save(userSaveEntityDto);
    }
}
