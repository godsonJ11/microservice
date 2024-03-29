package com.microservice.buyer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Response {
    private HttpStatus status;
    private String error;
    private Object data;
}
