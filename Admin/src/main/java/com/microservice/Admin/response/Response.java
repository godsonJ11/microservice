package com.microservice.Admin.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Response {
    private HttpStatus status;
    private String error;
    private Object data;
}
