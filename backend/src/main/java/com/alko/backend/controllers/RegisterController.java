package com.alko.backend.controllers;


import com.alko.backend.data.Login;
import com.alko.backend.mappers.Message;
import com.alko.backend.requests.RegisterRequest;
import com.alko.backend.services.LoginHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final LoginHelper loginHelper;

    @PostMapping
    public Message register(@RequestBody RegisterRequest registerRequest) {
        var cokolwiek = loginHelper.getLogin(registerRequest.getLogin());
        if(cokolwiek!=null){return new Message("takenusername");}
        if(registerRequest.getLogin()==null||registerRequest.getLogin().equals("")){return new Message("badusername");}
        if(registerRequest.getPassword()==null||registerRequest.getPassword().equals("")){return new Message("badpassword");}
        Login login = new Login();
        login.setLogin(registerRequest.getLogin());
        login.setPassword(registerRequest.getPassword());
        if(loginHelper.addLogin(login)!=null){return new Message("success");}
        return new Message("badpassword");
    }
}
