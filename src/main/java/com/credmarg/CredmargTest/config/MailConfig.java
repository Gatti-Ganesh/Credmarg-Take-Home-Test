package com.credmarg.CredmargTest.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.credmarg.CredmargTest.service.MockMailSender;

@Configuration
public class MailConfig {

	@Bean
    public JavaMailSender getJavaMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("localhost");
//        mailSender.setPort(25);
//        
//        mailSender.setUsername("ganeshgatti6@gmail.com");
//        mailSender.setPassword("Gani12@12");
//
//        Properties props = mailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.debug", "true");

        return new MockMailSender();
    }
}
