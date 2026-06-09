package com.springapp.financetracker.service.income;

import com.springapp.financetracker.controller.payload.NewIncomePayload;
import com.springapp.financetracker.entity.CustomUser;
import com.springapp.financetracker.entity.Income;
import com.springapp.financetracker.repository.CustomUserRepository;
import com.springapp.financetracker.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DefaultIncomeService implements IncomeService{
    private final IncomeRepository incomeRepository;
    private final CustomUserRepository customUserRepository;

    @Override
    public Income addIncome(NewIncomePayload payload){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        CustomUser user = customUserRepository
                .findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Income income = new Income();
        income.setAmount(payload.amount());
        income.setCreatedAt(LocalDateTime.now());
        income.setCustomUser(user);

        return income;
    }
}
