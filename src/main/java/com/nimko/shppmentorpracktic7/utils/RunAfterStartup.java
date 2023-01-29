package com.nimko.shppmentorpracktic7.utils;

import com.nimko.shppmentorpracktic7.models.User;
import com.nimko.shppmentorpracktic7.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RunAfterStartup {
    @Autowired
    UserRepository userRepository;
    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        {
            userRepository.save( new User("Vasya","user","user", Role.USER));
            userRepository.save( new User("Senya","admin","admin", Role.ADMIN));
        }

    }
}