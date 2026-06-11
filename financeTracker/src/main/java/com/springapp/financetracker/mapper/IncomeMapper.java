package com.springapp.financetracker.mapper;

import com.springapp.financetracker.dto.IncomeResponseDto;
import com.springapp.financetracker.entity.Income;
import org.springframework.stereotype.Component;

@Component
public class IncomeMapper {
    public IncomeResponseDto toDto(Income income){
        IncomeResponseDto dto = new IncomeResponseDto(
                income.getId(),
                income.getAmount(),
                income.getCreatedAt()
        );
        return dto;
    }
}
