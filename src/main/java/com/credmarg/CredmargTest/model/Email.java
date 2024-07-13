package com.credmarg.CredmargTest.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String recipientEmail;
	private String subject;
	private String body;
	private LocalDateTime sentAt;
	
	
	public Email() {
		
	}


	public Email(String recipientEmail, String subject, String body, LocalDateTime sentAt) {
		this.recipientEmail = recipientEmail;
		this.subject = subject;
		this.body = body;
		this.sentAt = sentAt;
	}


	public String getRecipientEmail() {
		return recipientEmail;
	}


	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public LocalDateTime getSentAt() {
		return sentAt;
	}


	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}
	
	
	
	
	
	
}
