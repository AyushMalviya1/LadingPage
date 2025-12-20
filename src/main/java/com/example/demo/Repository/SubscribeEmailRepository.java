package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.pojo.SubscribeEmail;

public interface SubscribeEmailRepository extends JpaRepository<SubscribeEmail, Integer>{
	
}
