package com.taniltekdemir.n11.bootcampgraduationproject.creditapply.service;

import com.taniltekdemir.n11.bootcampgraduationproject.common.exception.CommonException;
import com.taniltekdemir.n11.bootcampgraduationproject.common.exception.UserNotFoundException;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto.ApplyDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto.ApplySaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.entity.CreditApply;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.enums.EnumApplyStatus;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.enums.EnumApplyValidity;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.mapper.CreditAppMapper;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.repository.CreditAppRepository;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.service.entityService.CreditAppEntityService;
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

    public ApplyDto createCreditApp(ApplySaveEntityDto saveEntityDto) {

        CreditApply creditApply = CreditAppMapper.INSTANCE.convertApplicationSaveEntityDtoToCreditApp(saveEntityDto);
        creditApply.setApplicationValidity(EnumApplyValidity.ACTIVE);
        creditApply.setApplicationDate(LocalDate.now());
        creditApply.setApplicationStatus(EnumApplyStatus.EVALUATED);
        creditApply = creditAppEntityService.save(creditApply);
        log.info("{} userId li kullanıcının kredi basşvurusu kaydedildi", saveEntityDto.getUserId());
        return CreditAppMapper.INSTANCE.convertCreditApplicationToApplicationDto(creditApply);
    }

    public ApplyDto findAllByUserId(Long userId) {

        CreditApply creditApply = creditAppRepository.findFirstByUser_IdAndApplicationValidity(userId, EnumApplyValidity.ACTIVE);

        return CreditAppMapper.INSTANCE.convertCreditApplicationToApplicationDto(creditApply);
    }


    public void validationForApplication(ApplySaveEntityDto saveEntityDto) {

        if(saveEntityDto.getUserId() == null || saveEntityDto.getSalary() == null) {
            log.error("Kredi başvurusu için boş bırakılmış zorunlu alanlar var.");
            throw new CommonException("Kredi başvurusu için boş bırakılmış zorunlu alanlar var.");
        }

        Optional<User> optionalUser = userEntityService.findById(saveEntityDto.getUserId());
        if(!optionalUser.isPresent()) {
            throw new UserNotFoundException("Kayıtlı kullanıcı bulunamadı");
        }

        ApplyDto application = findAllByUserId(saveEntityDto.getUserId());
        if(application != null) {
            log.error("{} userId li kullanıcının aktif bir kredi başvursu vardır", saveEntityDto.getUserId());
            throw new CommonException("Aktif kredi başvurunuz vardır. Yeni kredi başvurusunda bulunamazsınız");
        }
    }


}
