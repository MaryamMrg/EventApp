package com.example.eventhello.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
@Id
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

}
