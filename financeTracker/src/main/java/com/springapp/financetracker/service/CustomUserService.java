package com.springapp.financetracker.service;

import com.springapp.financetracker.controller.payload.NewCustomUserPayload;
import com.springapp.financetracker.entity.Authority;
import com.springapp.financetracker.entity.CustomUser;
import com.springapp.financetracker.repository.AuthoritiesRepository;
import com.springapp.financetracker.repository.CustomUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserService implements DefaultCustomUserService{
    private final CustomUserRepository customUserRepository;
    private final AuthoritiesRepository authoritiesRepository;

    @Override
    public CustomUser addUser(NewCustomUserPayload payload){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        CustomUser user = new CustomUser();


        user.setUsername(payload.username());
        user.setPassword(bCryptPasswordEncoder.encode(payload.password()));
        user.setEmail(payload.email());
        user.setCreatedAt(LocalDateTime.now());

        Authority userRole = authoritiesRepository
                .findByAuthority("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("ROLE_USER does not exist"));
        user.setAuthorities(List.of(userRole));

        return this.customUserRepository.save(user);
    }

    @Override
    public CustomUser findByUsername(String username){
        return this.customUserRepository
                .findByUsername(username)
                .orElseThrow(() -> new RuntimeException(("User not found")));
    }
}
