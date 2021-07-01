package com.api.user.manage.userapimanage.mapper;

import com.api.user.manage.userapimanage.dto.UserDTO;
import com.api.user.manage.userapimanage.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toUser(UserDTO userDTO){
        UserEntity user = new UserEntity();

        user.setId(userDTO.getId());
        user.setBirthdate(userDTO.getBirthdate());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return user;
    }

    public UserDTO toUserDTO(UserEntity user){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setBirthdate(user.getBirthdate());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }
}
