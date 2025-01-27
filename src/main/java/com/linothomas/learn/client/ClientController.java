package com.linothomas.learn.client;

import com.linothomas.learn.client.DTO.LoginResponse;
import com.linothomas.learn.client.DTO.RegisterRequest;
import com.linothomas.learn.client.DTO.RegisterResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/clients")
public class ClientController {

    private final ClientService cService;

    @Autowired
    public ClientController(ClientService cService){
        this.cService = cService;
    }

    @ResponseBody
    @PostMapping(path = "/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest request){
        RegisterResponse resp = new RegisterResponse();
        Client c = new Client();

        c.setName(request.getName());
        c.setPassword(request.getPassword());
        c.setTokenMeta(request.getTokenMeta());
        c.setUserName(request.getUserName());

        try{
            cService.register(c);
        } catch(Exception e){
            resp.setMessage("failed");
            resp.setError(e.getMessage());
            return ResponseEntity.status(401).body(resp);
        }


        resp.setMessage("ok");
        return ResponseEntity.ok(resp);
    }



    @PostMapping(path = "/login")
    public ResponseEntity<LoginResponse> login(@RequestHeader("Authorization") String authHeader){
        LoginResponse resp = new LoginResponse();
        try{
            String token = cService.login(authHeader);
            resp.setToken(token);
            resp.setMessage("success");
            return ResponseEntity.ok(resp);
        } catch (Exception e){
            resp.setError(e.getMessage());
            resp.setMessage("failed");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resp);
        }

    }

}
