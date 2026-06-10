package com.springapp.financetracker.service.income;

import com.springapp.financetracker.controller.payload.NewIncomePayload;
import com.springapp.financetracker.controller.payload.UpdateIncomePayload;
import com.springapp.financetracker.entity.CustomUser;
import com.springapp.financetracker.entity.Income;
import com.springapp.financetracker.repository.CustomUserRepository;
import com.springapp.financetracker.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DefaultIncomeService implements IncomeService{
    private final IncomeRepository incomeRepository;
    private final CustomUserRepository customUserRepository;

    @Override
    @Transactional
    public Income addIncome(NewIncomePayload payload){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        CustomUser user = customUserRepository
                .findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Income income = new Income();
        income.setAmount(payload.amount());
        income.setCreatedAt(LocalDateTime.now());
        income.setUser(user);

        this.incomeRepository.save(income);

        return income;
    }

    @Override
    public Iterable<Income> getAllIncome(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        CustomUser user = customUserRepository
                .findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return this.incomeRepository.findByUserUsername(username);
    }

    @Override
    @Transactional
    public Income updateIncome(UpdateIncomePayload payload){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        CustomUser user = customUserRepository
                .findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Income income = incomeRepository
                .findByIdAndUserUsername(payload.incomeId(), username)
                .orElseThrow(() -> new NoSuchElementException("Income not found"));

        income.setAmount(payload.amount());
        return income;
    }

    @Override
    @Transactional
    public void deleteIncome(Integer id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Income income = incomeRepository
                .findByIdAndUserUsername(id, username)
                .orElseThrow(() -> new RuntimeException("Income not found"));

        this.incomeRepository.deleteById(id);
    }

    @Override
    public Income getIncome(Integer id){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Income income = incomeRepository
                .findByIdAndUserUsername(id, username)
                .orElseThrow(() -> new RuntimeException("Income not found"));

        return income;
    }

}
