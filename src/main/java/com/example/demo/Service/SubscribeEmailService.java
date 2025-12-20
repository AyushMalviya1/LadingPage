package com.example.demo.Service;

import java.util.List;

import com.example.demo.pojo.SubscribeEmail;

public interface SubscribeEmailService {

	boolean addEmail(String email);
	List<SubscribeEmail>getAllSubscriber();
}
