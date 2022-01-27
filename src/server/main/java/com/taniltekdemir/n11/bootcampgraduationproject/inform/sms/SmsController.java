package com.taniltekdemir.n11.bootcampgraduationproject.inform.sms;

import com.taniltekdemir.n11.bootcampgraduationproject.inform.dto.InformDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/inform/sms")
@CrossOrigin
@RequiredArgsConstructor
public class SmsController {

    private final SmsService smsService;

    @PostMapping("/sendSMS")
    public void sendSmsMessage(@RequestBody InformDto informDto) {
        try {
            smsService.sendSMS(informDto);
            log.info("Kredi sonucu sms olarak gönderildi");
        }catch (Exception e){
            log.error("SMS gönderilemedi, lütfen kontrol ediniz");
        }
    }
}
