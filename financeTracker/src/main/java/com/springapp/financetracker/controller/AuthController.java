package com.springapp.financetracker.controller;

import com.springapp.financetracker.controller.payload.CustomUserLoginPayload;
import com.springapp.financetracker.controller.payload.NewCustomUserPayload;
import com.springapp.financetracker.entity.CustomUser;
import com.springapp.financetracker.security.CustomUserDetailsService;
import com.springapp.financetracker.service.customUser.CustomUserService;
import com.springapp.financetracker.service.jwt.JWTservice;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthController {
    private final CustomUserService customUserService;
    private final CustomUserDetailsService customUserDetailsService;
    private final JWTservice jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public CustomUser createUser(@RequestBody NewCustomUserPayload payload){
        return this.customUserService.addUser(payload);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CustomUserLoginPayload payload, HttpServletResponse response){
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(payload.username());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        payload.username(),
                        payload.password()
                )
        );



        String accessToken = this.jwtService.generateToken(userDetails);

        Cookie cookie = new Cookie("accessToken", accessToken);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");

        response.addCookie(cookie);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/me")
    public ResponseEntity<?> getReqUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        CustomUser user = customUserService.findByUsername(username);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/status")
    public ResponseEntity<?> checkAuthStatus(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)){
            return ResponseEntity.ok(Map.of(
                    "authenticated", true,
                    "username", auth.getName()
            ));
        }
        return ResponseEntity.ok(Map.of("authenticated", false));
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response){
        Cookie cookie = new Cookie("accessToken", "");

        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return ResponseEntity.ok().build();
    }
}
