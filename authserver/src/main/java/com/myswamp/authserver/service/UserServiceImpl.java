package com.myswamp.authserver.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.myswamp.authserver.domain.User;
import com.myswamp.authserver.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository repository;

    private final Logger log = LoggerFactory.getLogger(getClass());

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) {
        return repository.findById(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public void create(User user) {
        repository.findById(user.getUsername()).ifPresent(it -> {
            throw new IllegalArgumentException("user already exists: " + it.getUsername());
        });

        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);

        repository.save(user);
        log.info("new user has been created: {}", user.getUsername());
    }

    

}