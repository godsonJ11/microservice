package com.microservice.buyer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "buyer_details")
public class BuyerDetails {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String password;
    private String type;
}
