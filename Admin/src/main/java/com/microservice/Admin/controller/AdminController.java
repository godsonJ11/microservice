package com.microservice.Admin.controller;

import com.microservice.Admin.model.AdminModel;
import com.microservice.Admin.repository.AdminRepository;
import com.microservice.Admin.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;
    @PostMapping("register")
    public ResponseEntity<Response> saveAdminDetails(@RequestBody AdminModel adminModel){
        Response response= new Response();
        Assert.notNull(adminModel,"Admin model is null");
        adminRepository.save(adminModel);
        response.setData(adminModel);
        return ResponseEntity.ok(response);
    }
    @GetMapping("fetch")
    public ResponseEntity<Response> getAllAdminDetails() throws InterruptedException {
        System.out.println("start");

        Response response= new Response();
        response.setData(adminRepository.findAll());
        return ResponseEntity.ok(response);
    }
    @GetMapping("fetchById/{id}")
    public ResponseEntity<Response> findById(@PathVariable("id") Integer id){
        Response response= new Response();
        response.setData(adminRepository.findById(id));
        return ResponseEntity.ok(response);
    }
}
