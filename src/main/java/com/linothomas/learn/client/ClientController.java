package com.linothomas.learn.client;

import ch.qos.logback.core.recovery.ResilientFileOutputStream;
import com.linothomas.learn.client.DTO.RegisterRequest;
import com.linothomas.learn.client.DTO.RegisterResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

        cService.register(c);

        resp.setMessage("ok");
        return ResponseEntity.ok(resp);
    }



    @PostMapping(path = "/login")
    public void login(){

    }

}
