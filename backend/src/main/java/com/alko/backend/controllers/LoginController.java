package com.alko.backend.controllers;


import com.alko.backend.mappers.Message;
import com.alko.backend.requests.LoginRequest;
import com.alko.backend.services.LoginHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginHelper loginHelper;
    @PostMapping
    Message login(@RequestBody LoginRequest loginRequest){
        System.out.println(loginRequest.getLogin());
        var cokolwiek = loginHelper.getLogin(loginRequest.getLogin());
        if(cokolwiek==null){return new Message("badusername");}
        if(cokolwiek.getPassword().equals(loginRequest.getPassword())){return new Message("success");}
        return new Message("badpassword");
    };

}
