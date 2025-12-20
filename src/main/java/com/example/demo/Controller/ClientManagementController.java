package com.example.demo.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.ServiceImpl.ClientManagementServiceImpl;
import com.example.demo.pojo.ClientManagement;

@RestController
@CrossOrigin("*")
public class ClientManagementController {

    @Autowired
    private ClientManagementServiceImpl service;

    @PostMapping(
        value = "/addClient",
        consumes = "multipart/form-data"
    )
    public ResponseEntity<?> addClient(
            @RequestParam("name") String name,
            @RequestParam("image") MultipartFile image,
            @RequestParam("description") String description,
            @RequestParam("designation") String designation
    ) throws IOException {

        boolean saved = service.addClient(name, image, description, designation);

        if (saved) {
            return ResponseEntity.ok("Client added successfully");
        } else {
            return ResponseEntity.badRequest().body("Client creation failed");
        }
    }

    @GetMapping("/getAllClient")
    public List<ClientManagement> getAllClient() {
        return service.getAllClient();
    }
}
