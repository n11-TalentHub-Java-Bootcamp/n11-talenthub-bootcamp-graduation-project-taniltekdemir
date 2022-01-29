package com.taniltekdemir.n11.bootcampgraduationproject.user.service;

import com.taniltekdemir.n11.bootcampgraduationproject.common.exception.CommonException;
import com.taniltekdemir.n11.bootcampgraduationproject.common.helper.TcknUtils;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.InfoDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
import com.taniltekdemir.n11.bootcampgraduationproject.user.mapper.UserMapper;
import com.taniltekdemir.n11.bootcampgraduationproject.user.repository.UserRepository;
import com.taniltekdemir.n11.bootcampgraduationproject.user.service.entityService.UserEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
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
        if(user == null) {
            throw new RuntimeException("Kullancı bulunamadı");
        }
        return user;
    }

    public UserDto save(UserSaveEntityDto userSaveEntityDto) {
        validationForSaveUser(userSaveEntityDto);
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

    public void validationForSaveUser(UserSaveEntityDto saveEntity) {
        if ((saveEntity.getName() == null || saveEntity.getName().isEmpty() ) ||
                (saveEntity.getSurname() == null || saveEntity.getSurname().isEmpty()) ||
                    (saveEntity.getDateOfBirth() == null || saveEntity.getDateOfBirth().isEmpty()) ||
                        (saveEntity.getPassword() == null || saveEntity.getPassword().isEmpty()) ||
                        (saveEntity.getTckn() == null || saveEntity.getTckn().isEmpty())) {
            throw new CommonException("Boş bırakılmış zorunlu alanlar var.");
        }

        if (!TcknUtils.isValidTckn(saveEntity.getTckn().toCharArray(), 0)) {
            throw new CommonException("Geçerli olmayan tckn girildi.");
        }

        if (saveEntity.getTelephone() == null || saveEntity.getTelephone().isEmpty()) {
            throw new CommonException("Telefon numarası girilmelidir.");
        } else {
            if (!(saveEntity.getTelephone().length() == 10 || saveEntity.getTelephone().length() == 11)) {
                throw new CommonException("Telefon numarası uzunluğu hatalı girildi.");
            }
        }

        if (saveEntity.getEmail() != null && !saveEntity.getEmail().isEmpty()) {
            if (saveEntity.getEmail().contains("ı") ||
                    saveEntity.getEmail().contains("İ") ||
                    saveEntity.getEmail().contains("ş") ||
                    saveEntity.getEmail().contains("Ş") ||
                    saveEntity.getEmail().contains("ç") ||
                    saveEntity.getEmail().contains("Ç") ||
                    saveEntity.getEmail().contains("ö") ||
                    saveEntity.getEmail().contains("Ö") ||
                    saveEntity.getEmail().contains("ü") ||
                    saveEntity.getEmail().contains("Ü") ||
                    saveEntity.getEmail().contains("ğ") ||
                    saveEntity.getEmail().contains("Ğ")) {
                throw new CommonException("E posta adresi Türkçe karakter içeremez.");
            }
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

    public List<InfoDto> findAllInfo() {
        return userRepository.getAllByInfo();
    }
}
