package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.ClientManagement;

public interface ClientManagementRepository extends JpaRepository<ClientManagement, Integer> {

}
