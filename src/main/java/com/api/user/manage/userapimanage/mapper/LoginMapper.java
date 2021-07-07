package com.api.user.manage.userapimanage.mapper;

import com.api.user.manage.userapimanage.dto.LoginDTO;
import com.api.user.manage.userapimanage.entity.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginMapper {

    public User toUser(LoginDTO loginDTO){
        User user = new User();

        user.setId(loginDTO.getId());
        user.setEmail(loginDTO.getEmail());
        user.setPassword(loginDTO.getPassword());

        return user;
    }

    public LoginDTO toUserDTO(User user){
        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setId(user.getId());
        loginDTO.setEmail(user.getEmail());
        loginDTO.setPassword(user.getPassword());

        return loginDTO;
    }

    public LoginDTO toOptionalDTO(Optional<User> user) {
        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setId(user.get().getId());
        loginDTO.setEmail(user.get().getEmail());
        loginDTO.setPassword(user.get().getPassword());

        return loginDTO;
    }

    public User toOptionalUser(Optional<User> userExists) {
        User user = new User();

        user.setId(userExists.get().getId());
        user.setEmail(userExists.get().getEmail());
        user.setPassword(userExists.get().getPassword());

        return user;
    }
}
