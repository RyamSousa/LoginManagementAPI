package com.api.user.manage.userapimanage.service;

import com.api.user.manage.userapimanage.dto.UserDTO;
import com.api.user.manage.userapimanage.dto.UserMessageDTO;
import com.api.user.manage.userapimanage.entity.User;
import com.api.user.manage.userapimanage.mapper.UserMapper;
import com.api.user.manage.userapimanage.repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Transactional
    public UserDTO save(UserDTO userDTO){

        User user = userMapper.toUser(userDTO);
        userRepository.save(user);
        userDTO = userMapper.toUserDTO(user);

        return userDTO;
    }

    public UserMessageDTO createMessageDTO(Long id, String message){
        return UserMessageDTO
                .builder()
                .messageDTO(message + id)
                .build();
    }
}
