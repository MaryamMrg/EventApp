package com.example.eventhello.Dto;

import com.example.eventhello.entities.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
  Long id;
  String username;
  Role role;


}
