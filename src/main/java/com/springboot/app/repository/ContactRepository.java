package com.springboot.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Serializable> {

	

}
