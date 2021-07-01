package com.api.user.manage.userapimanage.controller;

import com.api.user.manage.userapimanage.dto.UserDTO;
import com.api.user.manage.userapimanage.dto.UserMessageDTO;
import com.api.user.manage.userapimanage.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserMessageDTO createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @GetMapping
    public List<UserDTO> listAll(){
        return userService.listAll();
    }

}
