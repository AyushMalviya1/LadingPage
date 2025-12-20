package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.SubscribeEmailRepository;
import com.example.demo.Service.SubscribeEmailService;
import com.example.demo.pojo.SubscribeEmail;

@Service
public class SubscribeEmailServiceImpl implements SubscribeEmailService {

	@Autowired
	private SubscribeEmailRepository repository;
	
	@Override
	public boolean addEmail(String email) {
		
		SubscribeEmail subscribeEmail = new SubscribeEmail();
		subscribeEmail.setEmail(email);
		repository.save(subscribeEmail);
		
		return true;
	}

	@Override
	public List<SubscribeEmail> getAllSubscriber() {
		List<SubscribeEmail>list = repository.findAll();
		
		return list;
	}

}
