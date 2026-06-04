package com.springapp.financetracker.controller;

import com.springapp.financetracker.controller.payload.NewCustomUserPayload;
import com.springapp.financetracker.entity.CustomUser;
import com.springapp.financetracker.service.CustomUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class CustomUserController {
    private final CustomUserService customUserService;

    @PostMapping("/register")
    public CustomUser createUser(@RequestBody NewCustomUserPayload payload){
        System.out.println("Register HIT");
        return this.customUserService.addUser(payload);
    }
}
