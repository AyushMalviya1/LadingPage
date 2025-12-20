package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.ContactForm;

public interface ContactFormRepository extends JpaRepository<ContactForm, Integer> {

}
