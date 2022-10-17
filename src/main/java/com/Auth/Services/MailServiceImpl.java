package com.Auth.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class MailServiceImpl implements MailService{
    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void sendCodeByEmail(String to, String code) {
        SimpleMailMessage simpleMailMessage =new SimpleMailMessage();
        simpleMailMessage.setFrom("AliRa@marketplace.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("code Active");
        simpleMailMessage.setText(code);
        javaMailSender.send(simpleMailMessage);
    }
}
