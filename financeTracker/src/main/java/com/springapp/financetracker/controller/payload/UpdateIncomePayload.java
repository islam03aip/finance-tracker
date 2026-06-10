package com.springapp.financetracker.controller.payload;

import java.math.BigDecimal;

public record UpdateIncomePayload(Integer incomeId, BigDecimal amount) {
}
