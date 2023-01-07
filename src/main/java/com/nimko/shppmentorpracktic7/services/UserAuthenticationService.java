package com.nimko.shppmentorpracktic7.services;

import com.nimko.shppmentorpracktic7.models.User;
import com.nimko.shppmentorpracktic7.utils.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class UserAuthenticationService implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        List<UserDetails> users = List.of(
                new User("Vasya","user","user", Role.USER),
                new User("Senya","admin","admin", Role.ADMIN)
        );
        log.warn("{}",authentication.getName());
        UserDetails userDetails = users.stream()
                .filter(u -> u.getUsername().equals(authentication.getName()))
                .findFirst().orElseThrow();
        return new UsernamePasswordAuthenticationToken(
                userDetails,userDetails.getPassword(),userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
