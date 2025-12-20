package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ContactFormRepository;
import com.example.demo.Service.ContactFormService;
import com.example.demo.pojo.ContactForm;

@Service
public class ContactFormServiceImpl implements ContactFormService {

	@Autowired
	private ContactFormRepository repository;
	
	@Override
	public boolean addContactForm(ContactForm form) {
		repository.save(form);
		return true;
	}

	@Override
	public List<ContactForm> getAllForm() {
		List<ContactForm>list = repository.findAll();
		return list;
	}

}
