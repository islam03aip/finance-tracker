package com.springapp.financetracker.controller.payload;

import com.springapp.financetracker.entity.CustomUser;

import java.math.BigDecimal;

public record NewSpendingPayload(String name, BigDecimal amount, Integer categoryId) {

}
