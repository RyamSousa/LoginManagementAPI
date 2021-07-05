package com.api.user.manage.userapimanage.service;

import com.api.user.manage.userapimanage.dto.UserDTO;
import com.api.user.manage.userapimanage.entity.User;
import com.api.user.manage.userapimanage.exception.UserException;
import com.api.user.manage.userapimanage.mapper.UserMapper;
import com.api.user.manage.userapimanage.repository.UserRepository;

import com.api.user.manage.userapimanage.util.MessageUtil;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Transactional
    public UserDTO save(UserDTO userDTO){

        Optional<User> userExists = userRepository.findByEmail(userDTO.getEmail());

        if(userExists.isPresent()){
            throw new UserException(MessageUtil.USER_ALREADY_EXISTS);
        }

        User user = userMapper.toUser(userDTO);
        userRepository.save(user);
        userDTO = userMapper.toUserDTO(user);

        return userDTO;
    }


    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        List<UserDTO> usersDTO = new ArrayList<>();
        List<User> users = new ArrayList<>();

        users = userRepository.findAll();

        for (User user: users) {
            usersDTO.add(userMapper.toUserDTO(user));
        }

        return usersDTO;
    }
    @Transactional
    public UserDTO delete(Long id) {

        UserDTO userDTO = this.findById(id);

        userRepository.deleteById(userDTO.getId());

        return userDTO;
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        Optional<User> user = userRepository.findById(id);

        UserDTO userDTO = userMapper.toOptionalDTO(user);

        return userDTO;
    }

    @Transactional
    public UserDTO update(UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        userRepository.save(user);

        return userDTO;
    }
}
