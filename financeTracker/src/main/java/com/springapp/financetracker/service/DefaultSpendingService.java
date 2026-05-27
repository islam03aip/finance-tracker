package com.springapp.financetracker.service;

import com.springapp.financetracker.controller.payload.NewSpendingPayload;
import com.springapp.financetracker.entity.Category;
import com.springapp.financetracker.entity.Spending;
import com.springapp.financetracker.repository.CategoryRepository;
import com.springapp.financetracker.repository.SpendingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultSpendingService implements SpendingService {
    private final SpendingRepository spendingRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Iterable<Spending> getAllSpending() {
        return this.spendingRepository.findAll() ;
    }

    @Override
    @Transactional
    public Spending createSpending(NewSpendingPayload payload) {
        Category category = categoryRepository
                .findById(payload.categoryId())
                .orElseThrow(() -> new NoSuchElementException("Category not found"));
        Spending spending = new Spending();

        spending.setName(payload.name());
        spending.setAmount(payload.amount());
        spending.setCategory(category);
        return spendingRepository.save(spending);
    }

    @Override
    public Optional<Spending> findSpending(int spendingId) {
        return this.spendingRepository.findById(spendingId);
    }

    @Override
    @Transactional
    public void updateSpending(Integer spendingId, String name, BigDecimal amount) {
        this.spendingRepository.findById(spendingId)
                .ifPresentOrElse(spending -> {
                    spending.setName(name);
                    spending.setAmount(amount);
                }, () -> {
                    throw new NoSuchElementException();
                });
    }

    @Override
    @Transactional
    public void deleteSpending(int spendingId){
        this.spendingRepository.deleteById(spendingId);
    }
}
