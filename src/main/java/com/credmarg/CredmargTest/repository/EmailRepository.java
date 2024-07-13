package com.credmarg.CredmargTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credmarg.CredmargTest.model.Email;

public interface EmailRepository extends JpaRepository<Email, Long>{

}
