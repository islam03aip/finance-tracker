package com.springapp.financetracker.service;

import com.springapp.financetracker.controller.payload.NewSpendingPayload;
import com.springapp.financetracker.entity.Spending;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface SpendingService {
    Iterable<Spending> getAllSpending();
    Spending createSpending(NewSpendingPayload payload);
    void updateSpending(Integer id, String name, BigDecimal amount);
    Optional<Spending> findSpending(int spendingId);
    void deleteSpending(int spendingId);
}
