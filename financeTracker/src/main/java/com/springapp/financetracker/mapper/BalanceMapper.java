package com.springapp.financetracker.mapper;

import com.springapp.financetracker.dto.BalanceDto;
import com.springapp.financetracker.entity.Balance;
import org.springframework.stereotype.Component;

@Component
public class BalanceMapper {
    public BalanceDto toDto(Balance balance){
        BalanceDto dto = new BalanceDto(
                balance.getId(),
                balance.getAmount()
        );
        return dto;
    }
}
