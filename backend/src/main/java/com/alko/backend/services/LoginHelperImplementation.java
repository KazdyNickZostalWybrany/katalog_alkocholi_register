package com.alko.backend.services;


import com.alko.backend.data.Login;
import com.alko.backend.repositories.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginHelperImplementation implements LoginHelper {

    private final LoginRepository loginRepository;


    @Override
    public Login getLogin(String login) {
        return loginRepository.findByLogin(login);
    }
    @Override
    public Login addLogin(Login login) {
        return loginRepository.save(login);
    }
}
