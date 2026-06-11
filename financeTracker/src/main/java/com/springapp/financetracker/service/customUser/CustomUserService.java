package com.springapp.financetracker.service.customUser;

import com.springapp.financetracker.controller.payload.NewCustomUserPayload;
import com.springapp.financetracker.dto.UserResponseDto;
import com.springapp.financetracker.entity.Authority;
import com.springapp.financetracker.entity.CustomUser;
import com.springapp.financetracker.mapper.UserMapper;
import com.springapp.financetracker.repository.AuthoritiesRepository;
import com.springapp.financetracker.repository.CustomUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserService implements DefaultCustomUserService{
    private final CustomUserRepository customUserRepository;
    private final AuthoritiesRepository authoritiesRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto addUser(NewCustomUserPayload payload){
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

        this.customUserRepository.save(user);

        return userMapper.toDto(user);
    }

    @Override
    public CustomUser findByUsername(String username){
        return this.customUserRepository
                .findByUsername(username)
                .orElseThrow(() -> new RuntimeException(("User not found")));
    }
}
