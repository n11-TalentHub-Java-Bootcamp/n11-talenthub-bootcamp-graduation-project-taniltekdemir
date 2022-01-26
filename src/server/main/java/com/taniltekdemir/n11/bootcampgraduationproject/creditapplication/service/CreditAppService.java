package com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.service;

import com.taniltekdemir.n11.bootcampgraduationproject.common.exception.CommonException;
import com.taniltekdemir.n11.bootcampgraduationproject.common.exception.UserNotFoundException;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.dto.ApplicationDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.dto.ApplicationSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.entity.CreditApplication;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.enums.EnumApplicationStatus;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.enums.EnumApplicationValidity;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.mapper.CreditAppMapper;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.repository.CreditAppRepository;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.service.entityService.CreditAppEntityService;
import com.taniltekdemir.n11.bootcampgraduationproject.creditscore.service.CreditScoreService;
import com.taniltekdemir.n11.bootcampgraduationproject.user.entity.User;
import com.taniltekdemir.n11.bootcampgraduationproject.user.service.entityService.UserEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CreditAppService {

    private final CreditAppEntityService creditAppEntityService;
    private final CreditScoreService creditScoreService;
    private final CreditAppRepository creditAppRepository;
    private final UserEntityService userEntityService;

    public ApplicationDto createCreditApp(ApplicationSaveEntityDto saveEntityDto) {

        CreditApplication creditApplication = CreditAppMapper.INSTANCE.convertApplicationSaveEntityDtoToCreditApp(saveEntityDto);
        creditApplication.setApplicationValidity(EnumApplicationValidity.ACTIVE);
        creditApplication.setApplicationDate(LocalDate.now());
        creditApplication.setApplicationStatus(EnumApplicationStatus.EVALUATED);
        creditApplication = creditAppEntityService.save(creditApplication);
        log.info("{} userId li kullanıcının kredi basşvurusu kaydedildi", saveEntityDto.getUserId());
        return CreditAppMapper.INSTANCE.convertCreditApplicationToApplicationDto(creditApplication);
    }

    public ApplicationDto findAllByUserId(Long userId) {

        CreditApplication creditApplication = creditAppRepository.findFirstByUser_IdAndApplicationValidity(userId, EnumApplicationValidity.ACTIVE);

        return CreditAppMapper.INSTANCE.convertCreditApplicationToApplicationDto(creditApplication);
    }


    public void validationForApplication(ApplicationSaveEntityDto saveEntityDto) {

        if(saveEntityDto.getUserId() == null || saveEntityDto.getSalary() == null) {
            log.error("Kredi başvurusu için boş bırakılmış zorunlu alanlar var.");
            throw new CommonException("Kredi başvurusu için boş bırakılmış zorunlu alanlar var.");
        }

        Optional<User> optionalUser = userEntityService.findById(saveEntityDto.getUserId());
        if(!optionalUser.isPresent()) {
            throw new UserNotFoundException("Kayıtlı kullanıcı bulunamadı");
        }

        ApplicationDto application = findAllByUserId(saveEntityDto.getUserId());
        if(application != null) {
            log.error("{} userId li kullanıcının aktif bir kredi başvursu vardır", saveEntityDto.getUserId());
            throw new CommonException("Aktif kredi başvurunuz vardır. Yeni kredi başvurusunda bulunamazsınız");
        }
    }


}
