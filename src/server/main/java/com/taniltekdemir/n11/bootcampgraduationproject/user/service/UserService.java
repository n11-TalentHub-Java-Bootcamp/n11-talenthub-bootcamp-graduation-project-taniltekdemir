package com.taniltekdemir.n11.bootcampgraduationproject.user.service;

import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
import com.taniltekdemir.n11.bootcampgraduationproject.user.mapper.UserMapper;
import com.taniltekdemir.n11.bootcampgraduationproject.user.repository.UserRepository;
import com.taniltekdemir.n11.bootcampgraduationproject.user.service.entityService.UserEntityService;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserEntityService userEntityService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserDto> findAll() {
        List<User> userList = userEntityService.findAll();
        return UserMapper.INSTANCE.convertUserListToUserDtoList(userList);
    }

    public User findById(Long userId) {
        User user = userEntityService.getById(userId);
        return user;
    }

    public UserDto save(UserSaveEntityDto userSaveEntityDto) {
        validateUserRequest(userSaveEntityDto.getTckn());
        User user = UserMapper.INSTANCE.convertUserSaveEntityDtoToUser(userSaveEntityDto);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user = userEntityService.save(user);
        return UserMapper.INSTANCE.convertUserToUserDto(user);
    }

    private void validateUserRequest(String tckn) {
        User user = userEntityService.findByTckn(tckn);
        if (user != null) {
            log.error("Kayıtlı Tckn ile işlem kayıt işlemi denendi.");
            throw new RuntimeException("Kayıtlı Tckn ile işlem yaptınız.");
        }
    }

    public UserDto update(UserDto userDto) {
        User user = UserMapper.INSTANCE.convertUserDtoToUser(userDto);
        user = userEntityService.save(user);
        return UserMapper.INSTANCE.convertUserToUserDto(user);
    }

    public void delete(Long id) {
        User user = userEntityService.getById(id);
        userEntityService.delete(user);
    }

    public Long confirmUserInfo(String tckn, String dateOfBirth) {
        User user = userRepository.findFirstByTcknAndAndDateOfBirth(tckn, dateOfBirth);
        if (user == null) {
            log.error("Kredi sorguladığınız bilgiler eşleşmemektedir.");
            throw new RuntimeException("Hatalı bilgilerler kredi sorgusu yaptınız.");
        }
        return user.getId();
    }
}
