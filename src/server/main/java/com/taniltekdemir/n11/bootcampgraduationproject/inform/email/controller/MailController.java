package com.taniltekdemir.n11.bootcampgraduationproject.inform.email.controller;

import com.taniltekdemir.n11.bootcampgraduationproject.inform.dto.InformDto;
import com.taniltekdemir.n11.bootcampgraduationproject.inform.email.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/inform/mail")
@CrossOrigin
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @PostMapping("/sendMail")
    public void sendEmailMessage(@RequestBody InformDto informDto) {
        try {
            mailService.sendEmail(informDto);
            log.info("Kredi sonucu eposta olarak gönderildi");
        }catch (Exception e){
            log.error("Mail gönderilemedi, lütfen kontrol ediniz");
        }
    }
}
