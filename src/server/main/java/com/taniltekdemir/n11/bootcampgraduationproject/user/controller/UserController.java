package com.taniltekdemir.n11.bootcampgraduationproject.user.controller;

import com.taniltekdemir.n11.bootcampgraduationproject.common.exception.CommonException;
import com.taniltekdemir.n11.bootcampgraduationproject.common.helper.TcknUtils;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
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
        try {
            userService.validationForSaveUser(userSaveEntityDto);
            UserDto userDto = userService.save(userSaveEntityDto);
            log.info("{} tckn li Kullanıcı kaydedildi", userSaveEntityDto.getTckn());
            return ResponseEntity.ok(userDto);
        }catch (Exception e) {
            log.error("{} tckn li Kullanıcı bilgisi kaydedilemedi", userSaveEntityDto.getTckn());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) {
        try {
            UserDto updateUser = userService.update(userDto);
            return ResponseEntity.ok(updateUser);
        } catch(CommonException e) {
            log.error("{} tckn li Kullanıcı bilgisi güncellenemedi", userDto.getTckn());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        try {
            userService.delete(id);
            log.info("{} id li kullanıcı silindi", id);
        } catch (CommonException e) {
            log.error("Kullanıcı silinemedi");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByUserId(@PathVariable Long id){
        try {
            User user = userService.findById(id);
            return ResponseEntity.ok(user);
        } catch (CommonException e) {
            log.error("Kullanıcı bulunamadı");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
