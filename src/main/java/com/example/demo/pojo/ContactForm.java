package com.example.demo.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ContactForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fId;
	
	private String name;
	
	private String mobileNumber;
	
	private String city;
}
