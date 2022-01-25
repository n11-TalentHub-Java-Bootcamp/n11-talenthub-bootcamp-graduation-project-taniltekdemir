package com.taniltekdemir.n11.bootcampgraduationproject.auth.security;

import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
import com.taniltekdemir.n11.bootcampgraduationproject.user.service.entityService.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserEntityService userEntityService;

    @Override
    public UserDetails loadUserByUsername(String tckn) throws UsernameNotFoundException {

        User user = userEntityService.findByTckn(tckn);
        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {

        Optional<User> userOptional = userEntityService.findById(id);

        if (userOptional.isPresent()){
            User user = userOptional.get();
            return JwtUserDetails.create(user);
        } else {
            throw new RuntimeException("User not found!");
        }
    }
}
