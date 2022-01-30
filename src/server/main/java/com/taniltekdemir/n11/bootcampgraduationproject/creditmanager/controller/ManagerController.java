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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Manager Controller", description = "Here you can apply for a loan with Login and without registration. You can query the credit result")
public class ManagerController {

    private final CreditAppService creditAppService;
    private final ManagerService managerService;
    private final UserService userService;

    @PostMapping("/applyCredit")
    @Operation(summary = "Applying for a loan. Requires only salary and optional guarantee information - authorization is required")
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
    @Operation(summary = "Query the application result - authorization is not required")
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
    @Operation(summary = "Applying for a loan. In addition to salary and optional guarantee information, user information is also required. - authorization is not required")
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
