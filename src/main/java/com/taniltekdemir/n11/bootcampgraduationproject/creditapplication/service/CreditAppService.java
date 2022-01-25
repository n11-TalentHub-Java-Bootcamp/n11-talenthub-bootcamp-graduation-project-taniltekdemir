package com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.service;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.dto.ApplicationDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.dto.ApplicationSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.entity.CreditApplication;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.enums.EnumApplicationStatus;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.enums.EnumApplicationValidity;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.mapper.CreditAppMapper;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.repository.CreditAppRepository;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.service.entityService.CreditAppEntityService;
import com.taniltekdemir.n11.bootcampgraduationproject.creditscore.service.CreditScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CreditAppService {

    private final CreditAppEntityService creditAppEntityService;
    private final CreditScoreService creditScoreService;
    private final CreditAppRepository creditAppRepository;

    public ApplicationDto createCreditApp(ApplicationSaveEntityDto saveEntityDto) {

        CreditApplication creditApplication = CreditAppMapper.INSTANCE.convertApplicationSaveEntityDtoToCreditApp(saveEntityDto);
        creditApplication.setApplicationValidity(EnumApplicationValidity.ACTIVE);
        creditApplication.setApplicationDate(LocalDate.now());
        creditApplication.setApplicationStatus(EnumApplicationStatus.WAITING);

//        Boolean isExist = creditScoreService.isExistCreditScoreByUserId(saveEntityDto.getUserId());
//        if (!isExist) {
//            creditScoreService.create(saveEntityDto.getUserId());
//        }
        creditApplication = creditAppEntityService.save(creditApplication);

        return CreditAppMapper.INSTANCE.convertCreditApplicationToApplicationDto(creditApplication);
    }

    public List<ApplicationDto> findAllByUserId(Long userId) {

        List<CreditApplication> list = creditAppRepository.findAllByUser_IdAndApplicationValidity(userId, EnumApplicationValidity.ACTIVE);

        return CreditAppMapper.INSTANCE.convertCreditApplicationListToApplicationDtoList(list);
    }


    // Başvuru iptali metodu yazılabilir


}
