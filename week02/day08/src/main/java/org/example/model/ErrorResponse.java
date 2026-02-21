package org.example.model;

public class ErrorResponse {

    private final int code;
    private final String message;

    public ErrorResponse(int code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString(){
        return  "{ \"code\": " + code + ", \"message\": \"" + message + "\"}";


    }
}
