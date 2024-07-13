package com.credmarg.CredmargTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credmarg.CredmargTest.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {


	
}
