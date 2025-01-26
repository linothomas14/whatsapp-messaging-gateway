package com.linothomas.learn.client.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class RegisterRequest {

    @NotBlank
    private String name;

    @JsonProperty("user_name")
    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    @JsonProperty("token_meta")
    @NotBlank
    private String tokenMeta;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTokenMeta() {
        return tokenMeta;
    }

    public void setTokenMeta(String tokenMeta) {
        this.tokenMeta = tokenMeta;
    }
}
