package com.alko.backend.services;

import com.alko.backend.data.Login;

public interface LoginHelper {

    Login getLogin(String login);
    Login addLogin(Login login);
}
