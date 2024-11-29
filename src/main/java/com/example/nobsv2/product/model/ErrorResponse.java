package com.example.nobsv2.product.model;

import lombok.Getter;

@Getter
public class ErrorResponse {
    //can make your error message as big as you want with more properties
    private String message;

    public ErrorResponse(String message){
        this.message = message;
    }
}
