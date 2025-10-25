package com.dey.kaas.service;

import com.dey.kaas.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomeUserDetailsService implements UserDetailsService {

    UserRepository userRepository;

    public CustomeUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var v = userRepository.findByEmail(username);
        log.info(" loadUserByUsername User : {} Password : {}", username , null);
        if(v.isPresent())
            return org.springframework.security.core.userdetails.User.withUsername(v.get().getEmail())
                .password(v.get().getPassword())
                .authorities(v.get().getRoleEnum())
                .build();
        throw new UsernameNotFoundException("Username " + username + " is not Found!");
    }
}
