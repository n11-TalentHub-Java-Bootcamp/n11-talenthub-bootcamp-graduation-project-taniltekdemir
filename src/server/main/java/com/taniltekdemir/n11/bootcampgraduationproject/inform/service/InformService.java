package com.taniltekdemir.n11.bootcampgraduationproject.inform.service;

import com.taniltekdemir.n11.bootcampgraduationproject.inform.dto.InformDto;
import com.taniltekdemir.n11.bootcampgraduationproject.inform.email.service.MailService;
import com.taniltekdemir.n11.bootcampgraduationproject.inform.sms.SmsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class InformService {

    private final MailService mailService;
    private final SmsService smsService;

    public void notify(InformDto informDto) {
        if (informDto.getEmail() != null && informDto.getEmail() != "") {
            mailService.sendEmailMessage(informDto);
        }
        if (informDto.getPhone() != null && informDto.getPhone() != ""){
            smsService.sendSmsMessage(informDto);
        }
    }
}
