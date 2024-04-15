package com.finalproject.dm.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    @Qualifier("emailTaskExecutor")
    private ThreadPoolTaskExecutor emailTaskExecutor;

    @Async
    public void sendEmail(String toEmail, String subjcect, String body)
    {
        emailTaskExecutor.execute(()->
        {
            SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ngochung020300@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subjcect);

        mailSender.send(message);
        }
        );
    }
}
