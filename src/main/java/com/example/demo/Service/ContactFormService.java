package com.example.demo.Service;

import java.util.List;

import com.example.demo.pojo.ContactForm;

public interface ContactFormService {

	boolean addContactForm(ContactForm form);
	List<ContactForm>getAllForm();
}
