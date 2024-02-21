package com.microservice.Admin.repository;

import com.microservice.Admin.model.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminModel,Integer> {
}
