package com.microservice.buyer.repository;

import com.microservice.buyer.model.BuyerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<BuyerDetails,Integer> {
}
