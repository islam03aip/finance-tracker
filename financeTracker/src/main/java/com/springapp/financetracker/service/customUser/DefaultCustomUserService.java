package com.springapp.financetracker.service.customUser;

import com.springapp.financetracker.controller.payload.NewCustomUserPayload;
import com.springapp.financetracker.entity.CustomUser;

public interface DefaultCustomUserService {
    CustomUser addUser(NewCustomUserPayload payload);
    CustomUser findByUsername(String username);
}