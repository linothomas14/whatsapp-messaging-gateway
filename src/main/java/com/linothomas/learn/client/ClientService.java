package com.linothomas.learn.client;

import com.linothomas.learn.tokenClient.TokenClient;
import com.linothomas.learn.tokenClient.TokenRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientRepository cRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;


    public ClientService(ClientRepository cRepository, TokenRepository tokenRepository, PasswordEncoder passwordEncoder){
        this.cRepository = cRepository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public void register(Client c) throws Exception{

        Optional<Client> cExist = cRepository.findClientByUserName(c.getUserName());

        if(cExist.isPresent()){
             throw new Exception("Username already exist");
        }

        String hashedPassword = passwordEncoder.encode(c.getPassword());
        c.setPassword(hashedPassword);
        cRepository.save(c);

    }

    public boolean verifyPassword(String rawPassword, String hashedPassword) {
        return passwordEncoder.matches(rawPassword, hashedPassword);
    }

    public String login(String authHeader) throws Exception {

        String[] credentials = decodeBasicAuth(authHeader);

        String username = credentials[0];
        String password = credentials[1];

        Client c = cRepository.findClientByUserName(username)
                .orElseThrow(() -> new Exception("Invalid username or password"));

        if (!verifyPassword(password, c.getPassword())) {
            throw new Exception("Invalid username or password");
        }

        // Generate Token
        String token = UUID.randomUUID().toString();

        // Save Token in DB
        TokenClient tokenClient = new TokenClient();
        tokenClient.setClient(c);
        tokenClient.setToken(token);
        tokenClient.setExpiredAt(LocalDate.now().plusDays(3));
        tokenRepository.save(tokenClient);

        return token;

    }

    private String[] decodeBasicAuth(String authHeader) throws Exception {
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new Exception("Missing or invalid Authorization header");
        }

        String base64Credentials = authHeader.substring("Basic ".length());
        String credentials = new String(Base64.getDecoder().decode(base64Credentials));
        return credentials.split(":", 2);
    }
}
