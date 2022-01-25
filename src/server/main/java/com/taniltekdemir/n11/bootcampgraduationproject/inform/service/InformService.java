package com.taniltekdemir.n11.bootcampgraduationproject.inform.service;

import com.taniltekdemir.n11.bootcampgraduationproject.inform.dto.InformDto;
import com.taniltekdemir.n11.bootcampgraduationproject.inform.email.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class InformService {

    private final MailService mailService;

    public void information(InformDto informDto) {
        if (informDto.getEmail() != null) {
            mailService.sendEmailMessage(informDto);
        }
    }
}
