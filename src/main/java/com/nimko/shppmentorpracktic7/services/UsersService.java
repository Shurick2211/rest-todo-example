package com.nimko.shppmentorpracktic7.services;

import com.nimko.shppmentorpracktic7.dto.UserDto;
import com.nimko.shppmentorpracktic7.models.User;
import com.nimko.shppmentorpracktic7.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UsersService {

    private final UserRepository repository;

    @Autowired
    public UsersService(UserRepository repository) {
        this.repository = repository;
    }

    public UserDto registration(UserDto userDto){
        if (repository.findById(userDto.getLogin()).isPresent())
            throw new NoSuchElementException("The user exist!");
        User inUser = new User(userDto.getName(),
                userDto.getLogin(),
                userDto.getPassword(),
                userDto.getRole());
        User user = repository.save(inUser);
        return new UserDto(user.getName(),
                user.getLogin(),
                user.getPassword(),
                user.getRole());
    }
}
