package com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.controller;

import com.taniltekdemir.n11.bootcampgraduationproject.common.exception.CommonException;
import com.taniltekdemir.n11.bootcampgraduationproject.common.exception.UserNotFoundException;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.dto.ApplicationDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.dto.ApplicationSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.service.CreditAppService;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
import com.taniltekdemir.n11.bootcampgraduationproject.user.service.UserService;
import com.taniltekdemir.n11.bootcampgraduationproject.user.service.entityService.UserEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/applications")
@CrossOrigin
@RequiredArgsConstructor
public class CreditAppController {

    private final CreditAppService creditAppService;

    @PostMapping("/apply")
    public ResponseEntity<?> creditApply(@Valid @RequestBody ApplicationSaveEntityDto saveEntityDto) {
        try {
            creditAppService.validationForApplication(saveEntityDto);

            creditAppService.createCreditApp(saveEntityDto);
            return ResponseEntity.ok("Kredi Başvurusu Alındı");
        }catch (CommonException ex) {
            log.error(ex.getMessage());
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            log.error("Kredi Başvurusu tamamlanamadı.");
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
