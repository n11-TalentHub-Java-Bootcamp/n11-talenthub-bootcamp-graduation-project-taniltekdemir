package com.taniltekdemir.n11.bootcampgraduationproject.user.controller;

import com.taniltekdemir.n11.bootcampgraduationproject.common.exception.CommonException;
import com.taniltekdemir.n11.bootcampgraduationproject.common.helper.TcknUtils;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.InfoDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
import com.taniltekdemir.n11.bootcampgraduationproject.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "User Controller", description = "Here we can list, save, delete and update users.")
public class UserController {

    private final UserService userService;

    @GetMapping
    @Operation(summary = "Listing all customers - authorization is required")
    public ResponseEntity<?> getAll() {

        List<UserDto> userDtos = userService.findAll();

        return ResponseEntity.ok(userDtos);
    }

    @PostMapping
    @Operation(summary = "Add new customer - authorization is required")
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
    @Operation(summary = "Update existing customer information - authorization is required")
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
    @Operation(summary = "Delete with userId - authorization is required")
    public void delete(@PathVariable Long id){
        try {
            userService.delete(id);
            log.info("{} id li kullanıcı silindi", id);
        } catch (CommonException e) {
            log.error("Kullanıcı silinemedi");
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user Info with userId - authorization is required")
    public ResponseEntity<?> findByUserId(@PathVariable Long id){
        try {
            User user = userService.findById(id);
            return ResponseEntity.ok(user);
        } catch (CommonException e) {
            log.error("Kullanıcı bulunamadı");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/allInfo")
    @Operation(summary = "Lists all registered credit transactions with user information - authorization is required")
    public ResponseEntity<?> getAllInfo() {

        List<InfoDto> infoDtos = userService.findAllInfo();

        return ResponseEntity.ok(infoDtos);
    }

}
