package com.springapp.financetracker.service;

import com.springapp.financetracker.controller.payload.NewSpendingPayload;
import com.springapp.financetracker.entity.Spending;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface SpendingService {
    Iterable<Spending> getAllSpending();
    Spending createSpending(NewSpendingPayload payload);
    void updateSpending(Integer id, String name, BigDecimal amount, Integer categoryId);
    Optional<Spending> findSpending(int spendingId);
    void deleteSpending(int spendingId);
}
