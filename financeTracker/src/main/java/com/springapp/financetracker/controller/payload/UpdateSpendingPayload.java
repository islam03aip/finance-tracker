package com.springapp.financetracker.controller.payload;

import java.math.BigDecimal;

public record UpdateSpendingPayload(String name, BigDecimal amount, Integer categoryId) {
}
