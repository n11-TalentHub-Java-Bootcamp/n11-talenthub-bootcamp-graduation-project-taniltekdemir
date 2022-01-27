package com.taniltekdemir.n11.bootcampgraduationproject.inform.sms;

import com.taniltekdemir.n11.bootcampgraduationproject.common.exception.CommonException;
import com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.enums.EnumEvaluateStatus;
import com.taniltekdemir.n11.bootcampgraduationproject.inform.dto.InformDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Slf4j
@Service
@Transactional
public class SmsService {

    public Boolean sendSmsMessage(@RequestBody InformDto informDto) {
        try {
            sendSMS(informDto);
            log.info("Kredi sonucu sms olarak gönderildi");
            return true;
        }catch (Exception e){
            log.error("SMS gönderilemedi, lütfen kontrol ediniz");
            return false;
        }
    }

        public void sendSMS(InformDto informDto) {
            String content;
            String receiver = informDto.getPhone();
            if(informDto.getEvaluateStatus().equals(EnumEvaluateStatus.ACCEPTED)) {
                content = "Basvuru sonucunuz onaylanmistir \n kredi limitiniz " + informDto.getLimit() + " olarak belirlenmistir.";
            } else {
               content = "Basvuru sonucunuz rededilmistir.";
            }
            String apiUrl = "https://api.vatansms.net/api/v1/1toN";
            String jsonFormData = "{" +
                    " \"api_id\": \"56d50eacf85bfc4ee2528898\", " +
                    "\"api_key\": \"9d36cfc9bb1ca65d33c7e203\", " +
                    "\"sender\": \"SMS TEST\", \"message_type\": " +
                    "\"normal\", \"message\": \" " + content+ "\", " +
                    "\"phones\": [ \""+ receiver +"\" ] }";

            try {
                URL url = new URL(apiUrl);

                HttpURLConnection connect = (HttpURLConnection) url.openConnection();
                connect.setDoOutput(true);
                connect.setConnectTimeout(5000);
                connect.setDoInput(true);
                connect.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                connect.setRequestMethod("POST");

                OutputStream prepareFormData = connect.getOutputStream();
                prepareFormData.write(jsonFormData.getBytes("UTF-8"));
                prepareFormData.close();

                InputStream inputStream = new BufferedInputStream(connect.getInputStream());
                Scanner s = new Scanner(inputStream).useDelimiter("\\A");
                String result = s.hasNext() ? s.next() : "";

                System.out.println(result);

                inputStream.close();
                connect.disconnect();

            } catch (Exception e) {
                System.out.println("Bir hata ile karşılaşıldı : " + e.getMessage());
            }
        }
}
