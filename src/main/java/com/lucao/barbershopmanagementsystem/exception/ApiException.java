package com.lucao.barbershopmanagementsystem.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
