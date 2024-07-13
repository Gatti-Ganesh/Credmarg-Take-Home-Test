package com.credmarg.CredmargTest.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.credmarg.CredmargTest.model.Email;
import com.credmarg.CredmargTest.model.Vendor;
import com.credmarg.CredmargTest.repository.EmailRepository;
import com.credmarg.CredmargTest.repository.VendorRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class VendorService {

	@Autowired
	private VendorRepository repo;
	
	@Autowired
	private EmailRepository emailRepo;
	
	@Autowired
	private JavaMailSender mailSender;
	
	public Vendor saveVendor(Vendor vendor) {
		return repo.save(vendor);
	}
	
	public List<Vendor> getAllVendors(){
		return repo.findAll();
	}
	public void sendEmailToVendors(List<Vendor> vendors) {
		System.out.println("send mail method calling");
        vendors.forEach(vendor -> {
        	String body ="Sending payments to vendor " + vendor.getName() + " at upi " + vendor.getUpi();
        	sendEmail(vendor.getEmail(),body);
        	Email email=new Email();
        	email.setRecipientEmail(vendor.getEmail());
        	email.setSubject("Payment Notification");
        	email.setBody(body);
        	email.setSentAt(LocalDateTime.now());
        	emailRepo.save(email);
            System.out.println("Sending payments to vendor " + vendor.getName() + " at upi " + vendor.getUpi());
        });
    }
	
	private void sendEmail(String to, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(to);
            helper.setSubject("Payment Notification");
            helper.setText(content);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
	
	public List<Email> getAllEmails(){
		return emailRepo.findAll();
	}
	
	
}
