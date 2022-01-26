package com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.service;

import com.taniltekdemir.n11.bootcampgraduationproject.common.exception.CommonException;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.dto.ApplicationDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.dto.ApplicationSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.entity.CreditApplication;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.mapper.CreditAppMapper;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.repository.CreditAppRepository;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.service.entityService.CreditAppEntityService;
import com.taniltekdemir.n11.bootcampgraduationproject.user.service.entityService.UserEntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
        ApplicationSaveEntityDto applicationSaveEntityDto = CreditAppServiceDataProvider.getApplicationSaveEntityDto();
        ApplicationDto applicationDto = CreditAppServiceDataProvider.getApplicationDto();
        CreditApplication creditApplication = CreditAppServiceDataProvider.getCreditApplication();

        when(creditAppEntityService.save(ArgumentMatchers.any(CreditApplication.class))).thenReturn(creditApplication);

        ApplicationDto result = creditAppService.createCreditApp(applicationSaveEntityDto);

        assertEquals(applicationDto, result);
        assertEquals(1L, result.getId());
        assertEquals(BigDecimal.valueOf(50000), result.getGuarantee());
    }

    @Test
    void shouldFindAllByUserIdWhenExist() {
        CreditApplication creditApplication = CreditAppServiceDataProvider.getCreditApplication();
        ApplicationDto applicationDto = CreditAppMapper.INSTANCE.convertCreditApplicationToApplicationDto(creditApplication);
        when(creditAppRepository.findFirstByUser_IdAndApplicationValidity(any(),any())).thenReturn(creditApplication);

        ApplicationDto result = creditAppService.findAllByUserId(1L);

        assertEquals(applicationDto, result);
    }

    @Test
    void shouldNotValidationWhenNotSuitApplication() {
        ApplicationSaveEntityDto applicationSaveEntityDto = CreditAppServiceDataProvider.getApplicationSaveEntityDtoForVAlidation();
        try {
            creditAppService.validationForApplication(applicationSaveEntityDto);
        }catch (Exception ex){
            assertTrue(ex instanceof CommonException);
            assertEquals("Kredi başvurusu için boş bırakılmış zorunlu alanlar var.", ex.getMessage());
        }
    }
}