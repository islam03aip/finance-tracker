package com.springapp.financetracker.mapper;

import com.springapp.financetracker.dto.SpendingResponseDto;
import com.springapp.financetracker.entity.Spending;
import org.springframework.stereotype.Component;

@Component
public class SpendingMapper {
    public SpendingResponseDto toDto(Spending spending){
        SpendingResponseDto dto = new SpendingResponseDto(
                spending.getId(),
                spending.getName(),
                spending.getAmount(),
                spending.getCategory(),
                spending.getCreatedAt()
        );
        return dto;
    }
}
