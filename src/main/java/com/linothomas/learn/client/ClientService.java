package com.linothomas.learn.client;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository cRepository;
    private final PasswordEncoder passwordEncoder;

    public ClientService(ClientRepository cRepository, PasswordEncoder passwordEncoder){
        this.cRepository = cRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(Client c){

        String hashedPassword = passwordEncoder.encode(c.getPassword());
        c.setPassword(hashedPassword);
        cRepository.save(c);

    }

    public boolean verifyPassword(Client client, String rawPassword) {
        return passwordEncoder.matches(rawPassword, client.getPassword());
    }

}
