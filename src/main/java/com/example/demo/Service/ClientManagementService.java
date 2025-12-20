package com.example.demo.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.pojo.ClientManagement;

public interface ClientManagementService {

	boolean addClient(String name, MultipartFile image, String description, String designation) throws IOException;
	
	List<ClientManagement>getAllClient();
}
