package com.springapp.financetracker.service;

import com.springapp.financetracker.controller.payload.NewSpendingPayload;
import com.springapp.financetracker.entity.Category;
import com.springapp.financetracker.entity.CustomUser;
import com.springapp.financetracker.entity.Spending;
import com.springapp.financetracker.repository.CategoryRepository;
import com.springapp.financetracker.repository.CustomUserRepository;
import com.springapp.financetracker.repository.SpendingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    private final CustomUserRepository customUserRepository;

    @Override
    public Iterable<Spending> getAllSpending() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return this.spendingRepository.findByUserUsername(authentication.getName());
    }

    @Override
    @Transactional
    public Spending createSpending(NewSpendingPayload payload) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        CustomUser user = customUserRepository
                .findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Category category = categoryRepository
                .findById(payload.categoryId())
                .orElseThrow(() -> new NoSuchElementException("Category not found"));

        Spending spending = new Spending();

        spending.setName(payload.name());
        spending.setAmount(payload.amount());
        spending.setCategory(category);
        spending.setUser(user);
        return spendingRepository.save(spending);
    }

    @Override
    public Optional<Spending> findSpending(int spendingId) {
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        Spending spending = spendingRepository
                .findByIdAndUserUsername(spendingId, username)
                .orElseThrow(() -> new NoSuchElementException("Spending not found"));
        return this.spendingRepository.findById(spendingId);
    }

    @Override
    @Transactional
    public void updateSpending(Integer spendingId, String name, BigDecimal amount, Integer categoryId) {
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        Spending spending = spendingRepository
                .findByIdAndUserUsername(spendingId, username)
                .orElseThrow(() -> new NoSuchElementException("Spending not found"));
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new NoSuchElementException("Category not found"));

        spending.setName(name);
        spending.setAmount(amount);
        spending.setCategory(category);
    }

    @Override
    @Transactional
    public void deleteSpending(int spendingId){
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        Spending spending = spendingRepository
                .findByIdAndUserUsername(spendingId, username)
                .orElseThrow(() -> new NoSuchElementException("Spending not found"));
        this.spendingRepository.deleteById(spending.getId());
    }
}
