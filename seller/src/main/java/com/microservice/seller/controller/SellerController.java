package com.microservice.seller.controller;

import com.microservice.seller.client.AdminClient;
import com.microservice.seller.model.Seller;
import com.microservice.seller.repository.SellerRepository;
import com.microservice.seller.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/seller")
public class SellerController {
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private AdminClient adminClient;
    @PostMapping("register")
    public ResponseEntity<Response> saveAdminDetails(@RequestBody Seller seller){
        Response response= new Response();
        Assert.notNull(seller,"Admin model is null");
        sellerRepository.save(seller);
        response.setData(seller);
        return ResponseEntity.ok(response);
    }
    @GetMapping("fetch")
    public ResponseEntity<Response> getAllAdminDetails(){
        Response response= new Response();
        response.setData(sellerRepository.findAll());
        return ResponseEntity.ok(response);
    }
    @GetMapping("fetchById/{id}")
    public ResponseEntity<Response> findById(@PathVariable("id") Integer id){
        Response response= new Response();
        response.setData(sellerRepository.findById(id));
        return ResponseEntity.ok(response);
    }
    @GetMapping("calling")
    public void callingTheOtherServices(){
        System.out.println(adminClient.getAllAdminDetails().getBody().toString());
    }

}
