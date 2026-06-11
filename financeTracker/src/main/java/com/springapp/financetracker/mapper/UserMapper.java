package com.springapp.financetracker.mapper;

import com.springapp.financetracker.dto.UserResponseDto;
import com.springapp.financetracker.entity.CustomUser;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto toDto(CustomUser user){
        UserResponseDto dto = new UserResponseDto(
                user.getUsername(),
                user.getCreatedAt()
        );
        return dto;
    }
}
