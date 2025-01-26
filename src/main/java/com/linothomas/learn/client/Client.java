package com.linothomas.learn.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private Long ID;
    private String name;
    private String userName;
    private String password;
    private String tokenMeta;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate CreatedAt;

    @UpdateTimestamp
    private LocalDate UpdatedAt;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

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

    public LocalDate getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        CreatedAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        UpdatedAt = updatedAt;
    }
}
