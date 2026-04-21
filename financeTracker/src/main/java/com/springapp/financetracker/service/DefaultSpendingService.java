package com.springapp.financetracker.service;

import com.springapp.financetracker.entity.Spending;
import com.springapp.financetracker.repository.SpendingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultSpendingService implements SpendingService {
    private final SpendingRepository spendingRepository;

    @Override
    public List<Spending> getAllSpending() {
        return this.spendingRepository.getAll() ;
    }
}
