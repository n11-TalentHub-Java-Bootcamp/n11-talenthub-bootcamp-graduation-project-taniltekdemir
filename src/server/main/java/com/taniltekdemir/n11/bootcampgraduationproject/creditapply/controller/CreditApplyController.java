package com.taniltekdemir.n11.bootcampgraduationproject.creditapply.controller;

import com.taniltekdemir.n11.bootcampgraduationproject.common.exception.CommonException;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto.ApplySaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.service.CreditAppService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/applications")
@CrossOrigin
@RequiredArgsConstructor
public class CreditApplyController { //TODO: bu controller ı kaldırabiliriz

    private final CreditAppService creditAppService;

    @PostMapping("/apply")
    public ResponseEntity<?> creditApply(@Valid @RequestBody ApplySaveEntityDto saveEntityDto) {
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
