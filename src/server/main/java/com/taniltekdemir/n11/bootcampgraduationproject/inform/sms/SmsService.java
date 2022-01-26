package com.taniltekdemir.n11.bootcampgraduationproject.inform.sms;

import java.io.*;
import java.net.*;

public class SmsService {
        public void sendSMS() {
            try {
                URL u = new URL("http://panel.vatansms.com/panel/smsgonder1Npost.php");
                URLConnection uc = u.openConnection();
                HttpURLConnection connection = (HttpURLConnection) uc;
                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                OutputStream out = connection.getOutputStream();
                OutputStreamWriter wout = new OutputStreamWriter(out, "UTF-8");
                wout.write("data=<sms>"+
                        "<kno>KullanıcıNumaranız</kno>"+
                        "<kulad>KullanıcıAdınız</kulad>"+
                        "<sifre>Şifreniz</sifre>"+
                        "<gonderen>GönderenAdınız</gonderen>"+
                        "<mesaj>Deneme Mesajıdır</mesaj>"+
                        "<numaralar>5554443322,5553334422</numaralar>"+
                        "<tur>Normal</tur>"+ // Normal yada Turkce olabilir
                        "</sms>");
                //Xml'in içinde aşağıdaki alanları ekleyebilirsiniz.
                // '<zaman>2013-11-05 15:00:00</zaman>'+  İleri tarihli mesaj için kullanabilirsiniz.
                wout.flush();
                out.close();
                InputStream in = connection.getInputStream();
                int c;
                while ((c = in.read()) != -1) System.out.write(c);
                System.out.println();
                in.close();
                out.close();
                connection.disconnect();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
}
