package com.taniltekdemir.n11.bootcampgraduationproject.inform.email.service;

import com.taniltekdemir.n11.bootcampgraduationproject.common.exception.CommonException;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.enums.EnumEvaluateStatus;
import com.taniltekdemir.n11.bootcampgraduationproject.inform.dto.InformDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class MailService {

    private final JavaMailSender javaMailSender;

    public Boolean sendEmailMessage(@RequestBody InformDto informDto) {
        try {
            sendEmail(informDto);
            log.info("Kredi sonucu eposta olarak gönderildi");
            return true;
        }catch (Exception e){
            log.error("Mail gönderilemedi, lütfen kontrol ediniz");
            return false;
        }
    }

    public void sendEmail(InformDto informDto) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(informDto.getEmail());

        msg.setSubject("Kredi Başvuru Sonucunuz");
        if(informDto.getEvaluateStatus().equals(EnumEvaluateStatus.ACCEPTED)) {
            msg.setText("Başvuru sonucunuz onaylanmıştır \n kredi limitiniz " + informDto.getLimit() + " olarak belirlenmiştir.");
        } else {
            msg.setText("Başvuru sonucunuz rededilmiştir.");
        }

        javaMailSender.send(msg);
    }
}
