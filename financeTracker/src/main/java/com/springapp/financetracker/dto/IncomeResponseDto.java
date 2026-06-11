package com.springapp.financetracker.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record IncomeResponseDto(Integer id, BigDecimal amount, LocalDateTime createdAt) {
}
