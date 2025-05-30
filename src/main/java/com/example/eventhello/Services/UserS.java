package com.example.eventhello.Services;

import com.example.eventhello.Dto.UserDTO;
import com.example.eventhello.Mapper.UserMapper;
import com.example.eventhello.Repositories.UserRepository;
import com.example.eventhello.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserS {

    private final UserRepository userRepository;
      private final UserMapper userMapper;
    public UserS(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    public UserDTO register(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    public List<UserDTO> findAll() {
        List<UserDTO> userdtolist =userMapper.toDTOs(userRepository.findAll());
        return userdtolist;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
    public UserDTO update(Long id , UserDTO dto) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));

       UserDTO f_user= userMapper.toDTO(foundUser);
        f_user.setUsername(dto.getUsername());
        f_user.setRole(dto.getRole());
       User user= userMapper.toEntity(f_user);

        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }
}
