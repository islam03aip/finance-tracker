package com.springapp.financetracker.controller.payload;

import java.math.BigDecimal;

public record NewIncomePayload(BigDecimal amount) {
}
