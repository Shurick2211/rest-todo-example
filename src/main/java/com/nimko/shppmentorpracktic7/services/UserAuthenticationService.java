package com.nimko.shppmentorpracktic7.services;

import com.nimko.shppmentorpracktic7.models.User;
import com.nimko.shppmentorpracktic7.repo.UserRepository;
import com.nimko.shppmentorpracktic7.utils.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class UserAuthenticationService implements AuthenticationProvider {
    @Autowired
    UserRepository userRepository;





    @Override
    public Authentication authenticate(Authentication authentication) {
        UserDetails userDetails = userRepository.findById(authentication.getName()).orElse(null);
        if (userDetails == null
                || !userDetails.getPassword().equals(authentication.getCredentials().toString()))
            throw new BadCredentialsException("Wrong login or password!");
        log.warn("{}",userDetails);
        return new UsernamePasswordAuthenticationToken(
                userDetails,userDetails.getPassword(),userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}
