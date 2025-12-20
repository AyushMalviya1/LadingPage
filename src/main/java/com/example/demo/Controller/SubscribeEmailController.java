package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ServiceImpl.SubscribeEmailServiceImpl;
import com.example.demo.pojo.SubscribeEmail;

@RestController
@CrossOrigin("*")
public class SubscribeEmailController {

	@Autowired SubscribeEmailServiceImpl service;
	
	@PostMapping("/addEmail")
	public boolean addEmail(@RequestParam ("email")String email) {
		boolean response = service.addEmail(email);
		if(response) {
			return true;
		}else {
			return false;
		}
	}
	
	@GetMapping("/getAllEmail")
	public List<SubscribeEmail>getAllEmail(){
		List<SubscribeEmail>list = service.getAllSubscriber();
		return list;
	}
}
