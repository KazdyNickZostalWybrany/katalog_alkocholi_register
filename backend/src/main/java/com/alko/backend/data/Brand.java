package com.alko.backend.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

    @Id
    @GeneratedValue
    private long id;
    private String name;
}
