package com.credmarg.CredmargTest.service;

import java.io.InputStream;

import org.springframework.mail.MailException;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;



public class MockMailSender implements JavaMailSender{

	@Override
    public void send(SimpleMailMessage simpleMessage) {
        System.out.println("Mock email sent to: " + simpleMessage.getTo()[0]);
        System.out.println("Subject: " + simpleMessage.getSubject());
        System.out.println("Content: " + simpleMessage.getText());
    }

    @Override
    public void send(MimeMessage mimeMessage) {
        try {
            System.out.println("Mock email sent to: " + mimeMessage.getRecipients(MimeMessage.RecipientType.TO)[0]);
            System.out.println("Subject: " + mimeMessage.getSubject());
            System.out.println("Content: " + mimeMessage.getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send(MimeMessagePreparator mimeMessagePreparator) {
        // no-op
    }

    @Override
    public void send(MimeMessagePreparator... mimeMessagePreparators) {
        // no-op
    }

    @Override
    public void send(SimpleMailMessage... simpleMessages) {
        for (SimpleMailMessage simpleMessage : simpleMessages) {
            send(simpleMessage);
        }
    }

    @Override
    public MimeMessage createMimeMessage() {
        return new MimeMessage((Session) null);
    }

    @Override
    public MimeMessage createMimeMessage(InputStream contentStream) {
        try {
            return new MimeMessage((Session) null, contentStream);
        } catch (MessagingException e) {
            throw new MailParseException(e);
        }
    }

	@Override
	public void send(MimeMessage... mimeMessages) throws MailException {
		// TODO Auto-generated method stub
		
	}

}
