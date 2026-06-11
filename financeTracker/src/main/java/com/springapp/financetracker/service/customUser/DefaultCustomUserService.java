package com.springapp.financetracker.service.customUser;

import com.springapp.financetracker.controller.payload.NewCustomUserPayload;
import com.springapp.financetracker.dto.UserResponseDto;
import com.springapp.financetracker.entity.CustomUser;

public interface DefaultCustomUserService {
    UserResponseDto addUser(NewCustomUserPayload payload);
    CustomUser findByUsername(String username);
}