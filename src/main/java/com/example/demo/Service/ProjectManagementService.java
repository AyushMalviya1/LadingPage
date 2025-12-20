package com.example.demo.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.pojo.ProjectManagement;

public interface ProjectManagementService {
	
	boolean createProject(String name, MultipartFile image, String description);
	
	List<ProjectManagement>getAllProjects();

}
