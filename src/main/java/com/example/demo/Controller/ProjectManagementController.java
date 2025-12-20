package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.ProjectManagementService;
import com.example.demo.ServiceImpl.ProjectManagementServiceImpl;
import com.example.demo.pojo.ProjectManagement;

@RestController
@CrossOrigin("*")
public class ProjectManagementController {
	
	@Autowired 
	private ProjectManagementServiceImpl service;
	
	@PostMapping( value = "/createProject",
	        consumes = "multipart/form-data")
	public ResponseEntity<?> createProject(
            @RequestParam("name") String name,
            @RequestParam("image") MultipartFile image,
            @RequestParam("description") String description
    ) {
        boolean saved = service.createProject(name, image, description);

        if (saved) {
            return ResponseEntity.ok("Project created successfully");
        } else {
            return ResponseEntity.badRequest().body("Project creation failed");
        }
    }
	
	@GetMapping("/getAllProjects")
	public List<ProjectManagement>getAllProjects(){
		List<ProjectManagement>projects = service.getAllProjects();
		return projects;
	}
}
