package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.ProjectManagement;

public interface ProjectManagementRepo extends JpaRepository<ProjectManagement, Integer> {

}
