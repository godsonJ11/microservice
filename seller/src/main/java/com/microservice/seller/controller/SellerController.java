package com.microservice.seller.controller;

import com.microservice.seller.client.AdminClient;
import com.microservice.seller.model.Seller;
import com.microservice.seller.repository.SellerRepository;
import com.microservice.seller.response.Response;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

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
    @TimeLimiter(name = "admin")
    @CircuitBreaker(name = "admin",fallbackMethod = "fallBack")
    @Retry(name = "admin")
    public CompletableFuture<String>  callingTheOtherServices(){
        System.out.println(adminClient.getAllAdminDetails().getBody().toString());
        return CompletableFuture.supplyAsync(()->"success");
    }
    public CompletableFuture<String>  fallBack(Throwable th){
        System.out.println("admin service is not working");
        return CompletableFuture.supplyAsync(()->"please try again later ");
    }

}
