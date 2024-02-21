package com.microservice.buyer.controller;

import com.microservice.buyer.model.BuyerDetails;
import com.microservice.buyer.repository.BuyerRepository;
import com.microservice.buyer.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/buyer")
public class BuyerController {
    @Autowired
    private BuyerRepository buyerRepository;
    @PostMapping("register")
    public ResponseEntity<Response> saveBuyerDetails(@RequestBody BuyerDetails buyerDetails){
        Assert.notNull(buyerDetails,"buyer detail is null");
        Response response= new Response();
        buyerRepository.save(buyerDetails);
        response.setData(buyerDetails);
        return ResponseEntity.ok(response);
    }
    @GetMapping("fetch")
    public ResponseEntity<Response> findAllBuyer(){
        Response response= new Response();
        response.setData(buyerRepository.findAll());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/fetch/{id}")
    public ResponseEntity<Response> findById(@PathVariable("id")Integer id){
        Response response= new Response();
        response.setData(buyerRepository.findById(id));
        return ResponseEntity.ok(response);
    }
}
