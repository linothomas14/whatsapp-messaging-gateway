package com.linothomas.learn.client.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterResponse {

    private String message;
    private String error;

    public RegisterResponse(String message, String error) {
        this.message = message;
        this.error = error;
    }

    public RegisterResponse(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
