package com.alko.backend.repositories;

import com.alko.backend.data.Alcohol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlcoholRepository extends JpaRepository<Alcohol, Long> {

}
