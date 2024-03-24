package com.microservice.seller.client;

import com.microservice.seller.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "BUYER")
public interface BuyerClient {
    @GetMapping("fetch")
    ResponseEntity<Response> findAllBuyer();

}
