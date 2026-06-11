package com.springapp.financetracker.dto;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public record UserResponseDto(String username, LocalDateTime createdAt) {
}
