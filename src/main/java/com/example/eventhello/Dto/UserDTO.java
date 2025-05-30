package com.example.eventhello.Dto;

import com.example.eventhello.entities.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {
  Long id;
  String username;
  Role role;
  String password;

  public UserDTO() {
  }

  public UserDTO(Long id, String username, Role role, String password) {
    this.id = id;
    this.username = username;
    this.role = role;
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
