package com.nimko.shppmentorpracktic7.controllers;

import com.nimko.shppmentorpracktic7.dto.UserDto;
import com.nimko.shppmentorpracktic7.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<?> registration(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.registration(userDto));
    }
}
