package com.api.user.manage.userapimanage.service;

import com.api.user.manage.userapimanage.dto.LoginDTO;
import com.api.user.manage.userapimanage.entity.Login;
import com.api.user.manage.userapimanage.exception.LoginException;
import com.api.user.manage.userapimanage.mapper.LoginMapper;
import com.api.user.manage.userapimanage.repository.LoginRepository;

import com.api.user.manage.userapimanage.security.PasswordHash;
import com.api.user.manage.userapimanage.util.ValidateEmail;
import com.api.user.manage.userapimanage.util.MessageUtil;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginService {

    private LoginRepository loginRepository;
    private LoginMapper loginMapper;

    @Transactional
    public LoginDTO save(LoginDTO loginDTO) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        // Cria hash da senha
        String passSave = PasswordHash.passwordToHash(loginDTO.getPassword());
        loginDTO.setPassword(passSave);

        Optional<Login> loginExists = loginRepository.findByEmail(loginDTO.getEmail());

        if(loginExists.isPresent()){
            throw new LoginException(MessageUtil.USER_ALREADY_EXISTS);
        }

        if(!ValidateEmail.validate(loginDTO.getEmail())){
            throw new LoginException(MessageUtil.INVALID_EMAIL);
        }

        Login login = loginMapper.toUser(loginDTO);
        loginRepository.save(login);
        loginDTO = loginMapper.toUserDTO(login);

        return loginDTO;
    }


    @Transactional(readOnly = true)
    public List<LoginDTO> findAll() {
        List<LoginDTO> loginDTO = new ArrayList<>();
        List<Login> logins = new ArrayList<>();

        logins = loginRepository.findAll();

        for (Login user: logins) {
            loginDTO.add(loginMapper.toUserDTO(user));
        }

        return loginDTO;
    }
    @Transactional
    public LoginDTO delete(Long id) {

        LoginDTO loginDTO = this.findById(id);

        loginRepository.deleteById(loginDTO.getId());

        return loginDTO;
    }

    @Transactional(readOnly = true)
    public LoginDTO findById(Long id) {
        Optional<Login> login = loginRepository.findById(id);

        LoginDTO loginDTO = loginMapper.toOptionalDTO(login);

        return loginDTO;
    }

    @Transactional
    public LoginDTO update(LoginDTO loginDTO) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if(!ValidateEmail.validate(loginDTO.getEmail())){
            throw new LoginException(MessageUtil.INVALID_EMAIL);
        }
        // Cria hash da senha
        String passSave = PasswordHash.passwordToHash(loginDTO.getPassword());
        loginDTO.setPassword(passSave);

        Login login = loginMapper.toUser(loginDTO);
        loginRepository.save(login);

        return loginDTO;
    }
}
