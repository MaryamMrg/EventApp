package com.example.eventhello.Controllers;

import com.example.eventhello.entities.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserC {

    private Long id;
    private String username;
    private Role role;
}
