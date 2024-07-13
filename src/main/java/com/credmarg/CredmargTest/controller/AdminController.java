package com.credmarg.CredmargTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credmarg.CredmargTest.model.Email;
import com.credmarg.CredmargTest.model.Employee;
import com.credmarg.CredmargTest.model.Vendor;
import com.credmarg.CredmargTest.service.EmployeeService;
import com.credmarg.CredmargTest.service.VendorService;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private VendorService vendorService;
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.saveEmployee(employee));
	}
	
	@PostMapping("/vendors")
	public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
		return ResponseEntity.ok(vendorService.saveVendor(vendor));
	}
	
//	@PostMapping("/send-email")
//	public void sendEmial(@RequestBody Email email) {
//		String subject ="Vendor Payment";
//		String body ="Sending payments to vendor "+email.getRecipientEmail()+" at upi";
//		adminService.sendEmil(email.getRecipientEmail(), subject, body);
//	}
//	
	@PostMapping("/send-email")
	public ResponseEntity<Void> sendEmialToVendors(@RequestBody List<Vendor> vendors) {
		vendorService.sendEmailToVendors(vendors);
		System.out.println(vendors);
        return ResponseEntity.ok().build();
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@GetMapping("/vendors")
	public ResponseEntity<List<Vendor>> getAllVendors(){
		return ResponseEntity.ok(vendorService.getAllVendors());
	}
	
//	@GetMapping("/emails")
//	public List<Email> getAllSentEmails(){
//		return adminService.getAllEmails();
//	}
	
	@GetMapping("/emails")
	public ResponseEntity<List<Email>> getAllSentEmails(){
		return ResponseEntity.ok(vendorService.getAllEmails());
	}
	
}
