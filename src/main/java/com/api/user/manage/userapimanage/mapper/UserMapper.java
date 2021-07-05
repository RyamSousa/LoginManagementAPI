package com.api.user.manage.userapimanage.mapper;

import com.api.user.manage.userapimanage.dto.UserDTO;
import com.api.user.manage.userapimanage.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(UserDTO userDTO){
        User user = new User();

        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return user;
    }

    public UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }
}
