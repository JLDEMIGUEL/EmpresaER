package com.vipera.empresaer.rest.controllers;

import com.vipera.empresaer.dao.models.User;
import com.vipera.empresaer.dao.repositories.UserRepository;
import com.vipera.empresaer.rest.requests.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/public")
public class AuthController {

    @Autowired
    private UserRepository repository;

    @PostMapping("register")
    public ResponseEntity login(@RequestBody AuthRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        User saved = repository.save(user);

        return new ResponseEntity(saved,HttpStatus.OK);
    }
}
