package com.springapp.financetracker.dto;

import com.springapp.financetracker.entity.Category;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SpendingResponseDto(Integer id, String name, BigDecimal amount, Category category, LocalDateTime createdAt) {
}
