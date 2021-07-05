package com.api.user.manage.userapimanage.controller;

import com.api.user.manage.userapimanage.dto.UserDTO;
import com.api.user.manage.userapimanage.service.UserService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.save(userDTO));
    }
}
