package com.example.eventhello.Controllers;

import com.example.eventhello.Dto.UserDTO;
import com.example.eventhello.Services.UserS;
import com.example.eventhello.entities.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserC {
public final UserS userservice;


    public UserC(UserS userservice) {
        this.userservice = userservice;
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return userservice.findAll();
    }
    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userservice.register(userDTO);
    }
    @DeleteMapping
    public void deleteUser(@RequestBody Long id) {
        userservice.deleteById(id);
    }
    @PutMapping("{id}")
    public UserDTO updateUser(@RequestBody UserDTO userDTO,@PathVariable Long id) {
        return userservice.update(id,userDTO);
    }
}
