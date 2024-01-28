package com.alko.backend.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    String login;
    String password;
}
