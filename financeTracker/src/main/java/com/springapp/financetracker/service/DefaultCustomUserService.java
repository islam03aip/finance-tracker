package com.springapp.financetracker.service;

import com.springapp.financetracker.controller.payload.NewCustomUserPayload;
import com.springapp.financetracker.entity.CustomUser;

import java.util.Optional;

public interface DefaultCustomUserService {
    CustomUser addUser(NewCustomUserPayload payload);
    CustomUser findByUsername(String username);
}