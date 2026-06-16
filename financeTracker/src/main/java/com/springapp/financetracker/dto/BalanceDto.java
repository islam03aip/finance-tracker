package com.springapp.financetracker.dto;

import java.math.BigDecimal;

public record BalanceDto(Integer id, BigDecimal amount) {
}
