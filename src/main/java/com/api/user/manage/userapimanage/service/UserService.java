package com.api.user.manage.userapimanage.service;

import com.api.user.manage.userapimanage.dto.UserDTO;
import com.api.user.manage.userapimanage.dto.UserMessageDTO;
import com.api.user.manage.userapimanage.entity.UserEntity;
import com.api.user.manage.userapimanage.mapper.UserMapper;
import com.api.user.manage.userapimanage.repository.UserRepository;
import com.fasterxml.jackson.annotation.OptBoolean;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Transactional
    public UserMessageDTO createUser(UserDTO user){
        Optional<UserEntity> userExists =
                userRepository.findById(user.getId());

        if(userExists.isPresent()){
            throw new RuntimeException("Usuário já existe");
        }

        userRepository.save(userMapper.toUser(user));

        return createMessageDTO(user.getId(), "Usuário criado");
    }

    public List<UserDTO> listAll(){
        List<UserDTO> list = new ArrayList<>();
        UserDTO user = new UserDTO();
        user.setId(1L);
        list.add(user);
        return list;
    }

    public UserMessageDTO createMessageDTO(Long id, String message){
        return UserMessageDTO
                .builder()
                .messageDTO(message + id)
                .build();
    }
}
