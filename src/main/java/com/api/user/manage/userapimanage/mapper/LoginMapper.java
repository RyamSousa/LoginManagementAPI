package com.api.user.manage.userapimanage.mapper;

import com.api.user.manage.userapimanage.dto.LoginDTO;
import com.api.user.manage.userapimanage.entity.Login;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class LoginMapper {

    public Login toUser(LoginDTO loginDTO){
        Login login = new Login();

        login.setId(loginDTO.getId());
        login.setEmail(loginDTO.getEmail());
        login.setPassword(loginDTO.getPassword());

        return login;
    }

    public LoginDTO toUserDTO(Login login){
        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setId(login.getId());
        loginDTO.setEmail(login.getEmail());
        loginDTO.setPassword(login.getPassword());

        return loginDTO;
    }

    public LoginDTO toOptionalDTO(Optional<Login> login) {
        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setId(login.get().getId());
        loginDTO.setEmail(login.get().getEmail());
        loginDTO.setPassword(login.get().getPassword());

        return loginDTO;
    }

    public Login toOptionalUser(Optional<Login> loginExists) {
        Login login = new Login();

        login.setId(loginExists.get().getId());
        login.setEmail(loginExists.get().getEmail());
        login.setPassword(loginExists.get().getPassword());

        return login;
    }
}
