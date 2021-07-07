package com.api.user.manage.userapimanage.controller;

import com.api.user.manage.userapimanage.dto.LoginDTO;
import com.api.user.manage.userapimanage.service.LoginService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/login")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    private LoginService loginService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginDTO> create(@Valid @RequestBody LoginDTO loginDTO) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return ResponseEntity.ok(loginService.save(loginDTO));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginDTO> update(@Valid @RequestBody LoginDTO loginDTO) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return ResponseEntity.ok(loginService.update(loginDTO));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(loginService.delete(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LoginDTO>> findAll(){
        return ResponseEntity.ok(loginService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LoginDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(loginService.findById(id));
    }
}
