package com.springboot.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.bindings.ContactForm;
import com.springboot.app.service.ContactService;

@RestController
public class ContactRestController {

	@Autowired
	private ContactService service;

	@PostMapping("/submit")
	public String saveContact(@RequestBody ContactForm form) {

		String msg = service.saveContact(form);
		return msg;
}
	@GetMapping("/allContacts")
	public List<ContactForm> viewAllContacts(){
		return service.viewContacts();		
	}
	
	@GetMapping("/edit/{contactId}")
	public ContactForm editContact(@PathVariable Integer contactId)
	{
	ContactForm form=service.editContact(contactId);
	
	return form;
			
		
	}
	@GetMapping("/delete/{contactId}")
	public List<ContactForm> deleteContact(@PathVariable Integer contactId){
		return service.deleteContact(contactId);
	}
}
