package com.springapp.financetracker.service.income;

import com.springapp.financetracker.controller.payload.NewIncomePayload;
import com.springapp.financetracker.controller.payload.UpdateIncomePayload;
import com.springapp.financetracker.dto.IncomeResponseDto;
import com.springapp.financetracker.entity.CustomUser;
import com.springapp.financetracker.entity.Income;
import com.springapp.financetracker.mapper.IncomeMapper;
import com.springapp.financetracker.repository.CustomUserRepository;
import com.springapp.financetracker.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DefaultIncomeService implements IncomeService{
    private final IncomeRepository incomeRepository;
    private final CustomUserRepository customUserRepository;
    private final IncomeMapper incomeMapper;

    @Override
    @Transactional
    public IncomeResponseDto addIncome(NewIncomePayload payload){
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

        return incomeMapper.toDto(income);
    }

    @Override
    public List<IncomeResponseDto> getAllIncome(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        CustomUser user = customUserRepository
                .findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Iterable<Income> incomes = this.incomeRepository.findByUserUsername(username);
        List<IncomeResponseDto> result = new ArrayList<>();
        incomes.forEach(income -> result.add(incomeMapper.toDto(income)));
        return result;
    }

    @Override
    @Transactional
    public IncomeResponseDto updateIncome(UpdateIncomePayload payload){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        CustomUser user = customUserRepository
                .findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Income income = incomeRepository
                .findByIdAndUserUsername(payload.incomeId(), username)
                .orElseThrow(() -> new NoSuchElementException("Income not found"));

        income.setAmount(payload.amount());
        return incomeMapper.toDto(income);
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
    public IncomeResponseDto getIncome(Integer id){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Income income = incomeRepository
                .findByIdAndUserUsername(id, username)
                .orElseThrow(() -> new RuntimeException("Income not found"));

        return incomeMapper.toDto(income);
    }

}
