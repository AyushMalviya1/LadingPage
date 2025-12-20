package com.example.demo.ServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.example.demo.Repository.ClientManagementRepository;
import com.example.demo.Service.ClientManagementService;
import com.example.demo.pojo.ClientManagement;

@Service
public class ClientManagementServiceImpl implements ClientManagementService {

	@Autowired
	private Cloudinary cloudinary;
	
	@Autowired
	private ClientManagementRepository repository;
	
	@Override
	public boolean addClient(String name, MultipartFile image, String description, String designation)throws IOException {
		
		Map data = cloudinary.uploader().upload(image.getBytes(),Map.of());
		
		ClientManagement client = new ClientManagement();
		
		client.setName(name);
		client.setDescription(description);
		client.setImage((String) data.get("secure_url"));
		client.setDesignation(designation);
		
		ClientManagement client1 =  repository.save(client);
		
		return true;
	}

	@Override
	public List<ClientManagement> getAllClient() {
		List<ClientManagement>clients = repository.findAll();
		return clients;
	}

}
