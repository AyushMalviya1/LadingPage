package com.example.demo.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.example.demo.Repository.ProjectManagementRepo;
import com.example.demo.Service.ProjectManagementService;
import com.example.demo.pojo.ProjectManagement;

@Service
public class ProjectManagementServiceImpl implements ProjectManagementService{

	@Autowired
	private ProjectManagementRepo repo;
	
	@Autowired
	private Cloudinary cloudinary;
	
	@Override
	public boolean createProject(String name, MultipartFile image, String description) {
		try {
			Map data = cloudinary.uploader().upload(image.getBytes(), Map.of());
			
			ProjectManagement project = new ProjectManagement();
			project.setName(name);
			project.setImage((String) data.get("secure_url"));
			project.setDescription(description);
			repo.save(project);
			return true;
		} catch (Exception e) {
			return false;
		}	
	}

	@Override
	public List<ProjectManagement> getAllProjects() {
		List<ProjectManagement>projects = repo.findAll();	
		return projects;
	}	
}
