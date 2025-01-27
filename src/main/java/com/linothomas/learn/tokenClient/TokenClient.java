package com.linothomas.learn.tokenClient;

import com.linothomas.learn.client.Client;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
public class TokenClient {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long ID;
    private String Token;
    private LocalDate ExpiredAt;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false) // Foreign key ke tabel Client
    private Client client;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate CreatedAt;

    @UpdateTimestamp
    private LocalDate UpdatedAt;


    public TokenClient(){}

    public TokenClient(Long ID, String token, LocalDate expiredAt, Client client, LocalDate createdAt, LocalDate updatedAt) {
        this.ID = ID;
        Token = token;
        ExpiredAt = expiredAt;
        this.client = client;
        CreatedAt = createdAt;
        UpdatedAt = updatedAt;
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public LocalDate getExpiredAt() {
        return ExpiredAt;
    }

    public void setExpiredAt(LocalDate expiredAt) {
        ExpiredAt = expiredAt;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
