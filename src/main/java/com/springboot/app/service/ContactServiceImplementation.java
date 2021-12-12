package com.springboot.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.bindings.ContactForm;
import com.springboot.app.entities.Contact;
import com.springboot.app.repository.ContactRepository;

@Service
public class ContactServiceImplementation implements ContactService {

	// injecting a dependency
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public String saveContact(ContactForm form) {
		// receiving binding form data or obj as parameter
		Contact contact = new Contact();

		// copy the binding form obj to entity obj
		BeanUtils.copyProperties(form, contact);
		contact = contactRepo.save(contact);
		if (contact.getContactId() != null) {
			return "Success";

		}
		return "Failed";

	}

	@Override
	public List<ContactForm> viewContacts() {
		List<ContactForm> list = new ArrayList<>();
		List<Contact> findAll = contactRepo.findAll();

		for (Contact entity : findAll) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			list.add(form);

		}

		return list;
	}

	@Override
	public ContactForm editContact(Integer contactId) {
		Optional<Contact> findById = contactRepo.findById(contactId);
		if (findById.isPresent()) {
			Contact entity = findById.get();
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			return form;
		}
		return null;

	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {
		contactRepo.deleteById(contactId);
		// getting latest data from table and returning
		List<ContactForm> dataList = new ArrayList<>();
		List<Contact> findAll = contactRepo.findAll();

		for (Contact contacts : findAll) {
			ContactForm contactform = new ContactForm();
			BeanUtils.copyProperties(contacts, contactform);
			dataList.add(contactform);
		}
		return dataList;

	}
}
