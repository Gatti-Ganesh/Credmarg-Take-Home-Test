package com.credmarg.CredmargTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credmarg.CredmargTest.model.Employee;
import com.credmarg.CredmargTest.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;
	
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}
	
	
	
//	public void sendEmil(String email, String subject, String body) {
//		Email emailObj =new Email();
//	    emailObj.setRecipientEmail(email);
//	    emailObj.setSubject(subject);
//	    emailObj.setBody(body);
//	    emailObj.setSentAt(LocalDateTime.now());
//	    repo.getSentEmails().add(emailObj);
//	}
//	
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	
	
	
}
