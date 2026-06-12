package com.springapp.financetracker.service.spending;

import com.springapp.financetracker.controller.payload.NewSpendingPayload;
import com.springapp.financetracker.dto.SpendingResponseDto;
import com.springapp.financetracker.entity.Spending;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface SpendingService {
    List<SpendingResponseDto> getAllSpending();
    ResponseEntity<SpendingResponseDto> createSpending(NewSpendingPayload payload);
    void updateSpending(Integer id, String name, BigDecimal amount, Integer categoryId);
    ResponseEntity<SpendingResponseDto> findSpending(int spendingId);
    void deleteSpending(int spendingId);
    List<SpendingResponseDto> getSpendingsByCategory(Integer categoryId);
}
