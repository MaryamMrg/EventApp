package com.example.eventhello.Mapper;

import com.example.eventhello.Dto.UserDTO;
import com.example.eventhello.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDTO dto);
    UserDTO toDTO(User user);
    List<UserDTO> toDTOs(List<User> users);


}