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
@RequestMapping("/users")
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

        userService.validationForSaveUser(userSaveEntityDto);

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

}
