package com.alko.backend.repositories;

import com.alko.backend.data.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByLogin(String login);
}
