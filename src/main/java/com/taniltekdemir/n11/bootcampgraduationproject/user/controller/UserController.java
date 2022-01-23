package com.taniltekdemir.n11.bootcampgraduationproject.user.controller;

import com.taniltekdemir.n11.bootcampgraduationproject.common.exception.CommonException;
import com.taniltekdemir.n11.bootcampgraduationproject.common.helper.TcknUtils;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getAll() {

        List<UserDto> userDtos = userService.findAll();

        return ResponseEntity.ok(userDtos);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody UserSaveEntityDto userSaveEntityDto) {

        validationForSaveUser(userSaveEntityDto);

        UserDto userDto = userService.save(userSaveEntityDto);

        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) {
        try {
            UserDto updateUser = userService.update(userDto);
            return ResponseEntity.ok(updateUser);
        } catch(CommonException e) {
            log.error("Kullanıcı bilgisi güncellenemedi");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        try {
            userService.delete(id);
        } catch (CommonException e) {
            log.error("Kullanıcı silinemedi");
        }
    }

    private void validationForSaveUser(UserSaveEntityDto saveEntity) {
        if (saveEntity.getName().isEmpty() || saveEntity.getSurname().isEmpty()
                || saveEntity.getDateOfBirth().isEmpty() || saveEntity.getTckn().isEmpty()) {
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
}
