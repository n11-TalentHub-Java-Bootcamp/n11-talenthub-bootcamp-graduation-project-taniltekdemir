package com.taniltekdemir.n11.bootcampgraduationproject.creditapply.service;

import com.taniltekdemir.n11.bootcampgraduationproject.common.exception.CommonException;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto.ApplyDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto.ApplySaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.entity.CreditApply;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.mapper.CreditAppMapper;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.repository.CreditAppRepository;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.service.entityService.CreditAppEntityService;
import com.taniltekdemir.n11.bootcampgraduationproject.user.service.entityService.UserEntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreditAppServiceTest {

    @InjectMocks
    private CreditAppService creditAppService;

    @Mock
    private CreditAppEntityService creditAppEntityService;
    @Mock
    private CreditAppRepository creditAppRepository;
    @Mock
    private UserEntityService userEntityService;

    @Test
    void createCreditApp() {
        ApplySaveEntityDto applySaveEntityDto = CreditAppServiceDataProvider.getApplicationSaveEntityDto();
        ApplyDto applyDto = CreditAppServiceDataProvider.getApplicationDto();
        CreditApply creditApply = CreditAppServiceDataProvider.getCreditApplication();

        when(creditAppEntityService.save(ArgumentMatchers.any(CreditApply.class))).thenReturn(creditApply);

        ApplyDto result = creditAppService.createCreditApp(applySaveEntityDto);

        assertEquals(applyDto, result);
        assertEquals(1L, result.getId());
        assertEquals(BigDecimal.valueOf(50000), result.getGuarantee());
    }

    @Test
    void shouldFindAllByUserIdWhenExist() {
        CreditApply creditApply = CreditAppServiceDataProvider.getCreditApplication();
        ApplyDto applyDto = CreditAppMapper.INSTANCE.convertCreditApplicationToApplicationDto(creditApply);
        when(creditAppRepository.findFirstByUser_IdAndApplicationValidity(any(),any())).thenReturn(creditApply);

        ApplyDto result = creditAppService.findAllByUserId(1L);

        assertEquals(applyDto, result);
    }

    @Test
    void shouldNotValidationWhenNotSuitApplication() {
        ApplySaveEntityDto applySaveEntityDto = CreditAppServiceDataProvider.getApplicationSaveEntityDtoForVAlidation();
        try {
            creditAppService.validationForApplication(applySaveEntityDto);
        }catch (Exception ex){
            assertTrue(ex instanceof CommonException);
            assertEquals("Kredi başvurusu için boş bırakılmış zorunlu alanlar var.", ex.getMessage());
        }
    }
}