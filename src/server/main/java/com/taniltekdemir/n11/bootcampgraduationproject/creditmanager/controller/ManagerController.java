package com.taniltekdemir.n11.bootcampgraduationproject.creditmanager.controller;

import com.taniltekdemir.n11.bootcampgraduationproject.auth.dto.InterrogateDto;
import com.taniltekdemir.n11.bootcampgraduationproject.common.exception.CommonException;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto.ApplyDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto.ApplyExtendedSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto.ApplySaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.service.CreditAppService;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.entity.EvaluateReport;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.strategy.substrategy.payload.EvaluationResult;
import com.taniltekdemir.n11.bootcampgraduationproject.creditmanager.mapper.ManageMapper;
import com.taniltekdemir.n11.bootcampgraduationproject.creditmanager.service.ManagerService;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/managers")
@CrossOrigin
@RequiredArgsConstructor
public class ManagerController {

    private final CreditAppService creditAppService;
    private final ManagerService managerService;
    private final UserService userService;

    @PostMapping("/applyCredit")
    public ResponseEntity<?> applyCredit(@Valid @RequestBody ApplySaveEntityDto saveEntityDto) {
        try {
            creditAppService.validationForApplication(saveEntityDto);
            EvaluationResult result = managerService.applyCredit(saveEntityDto);
            return ResponseEntity.ok(result);
        }catch (CommonException ex) {
            log.error(ex.getMessage());
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            log.error("Kredi Başvurusu tamamlanamadı.");
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/interrogate")
    public ResponseEntity<?> interrogateCredit(@Valid @RequestBody InterrogateDto interrogateDto) {
        try {
            Long userId = userService.confirmUserInfo(interrogateDto.getTckn(), interrogateDto.getDateOfBirth());
            ApplyDto dto = creditAppService.findAllByUserId(userId);
            EvaluateReport result = managerService.getResultByApplicationId(dto.getId());
            return ResponseEntity.ok(new EvaluationResult(result.getEvaluateStatus(), result.getLimitOfCredit()));
        }catch (CommonException ex) {
            log.error(ex.getMessage());
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            log.error("Kredi sonucu sorgusu tamamlanamadı.");
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/applyCreditWithoutRegistered")
    public ResponseEntity<?> applyCreditWithoutRegistered(@Valid @RequestBody ApplyExtendedSaveEntityDto saveEntityDto) {
        try {
            UserSaveEntityDto userSaveEntityDto = ManageMapper.INSTANCE.convertToAppAllInfoSaveEntityToUserSaveEntityDto(saveEntityDto);
            UserDto userDto = userService.save(userSaveEntityDto);
            ApplySaveEntityDto saveEntity = ManageMapper.INSTANCE.convertToAppAllInfoSaveEntityToApplicationSaveEntityDto(saveEntityDto);
            saveEntity.setUserId(userDto.getId());
            EvaluationResult result = managerService.applyCredit(saveEntity);
            return ResponseEntity.ok(result);
        }catch (CommonException ex) {
            log.error(ex.getMessage());
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            log.error("Kredi Başvurusu tamamlanamadı.");
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
