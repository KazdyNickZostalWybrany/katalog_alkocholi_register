package com.alko.backend.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    String login;
    String password;
}
