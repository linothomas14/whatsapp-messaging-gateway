package com.linothomas.learn.client.DTO;

public class LoginResponse {

    private String message;
    private String token;
    private String error;

    public LoginResponse(String message, String token, String error) {
        this.message = message;
        this.token = token;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
