package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Repository.ClientManagementRepository;
import com.example.demo.ServiceImpl.ContactFormServiceImpl;
import com.example.demo.pojo.ContactForm;

@RestController
@CrossOrigin("*")
public class ContactFormController {

 
	@Autowired
	private ContactFormServiceImpl service;

   
	@PostMapping("/addContactForm")
	public boolean addContactForm(
			@RequestParam ("name")String name,
			@RequestParam ("mobileNumber") String mobileNumber,
			@RequestParam ("city") String city
			) {
		ContactForm form = new ContactForm();
		form.setName(name);
		form.setMobileNumber(mobileNumber);
		form.setCity(city);
		boolean response = service.addContactForm(form);
		if(response) {
			return true;
		}else {
			return false;
		}
	}
	
	@GetMapping("/getAllForm")
	public List<ContactForm>getAllForm(){
		List<ContactForm>list = service.getAllForm();
		return list;
	}
}
