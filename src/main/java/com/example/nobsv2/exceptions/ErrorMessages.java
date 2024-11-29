package com.example.nobsv2.exceptions;

public enum ErrorMessages {
    PRODUCT_NOT_FOUND("Product Not Found!"),
    //can add to this list over time
    //messages all in one place
    NAME_REQUIRED("Name is required"),
    DESCRIPTION_LENGTH("Description must be 20 characters"),
    PRICE_CANNOT_BE_NEGATIVE("Price cannot be negative");

    private final String message;

    ErrorMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
