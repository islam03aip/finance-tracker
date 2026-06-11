package com.springapp.financetracker.service.income;

import com.springapp.financetracker.controller.payload.NewIncomePayload;
import com.springapp.financetracker.controller.payload.UpdateIncomePayload;
import com.springapp.financetracker.dto.IncomeResponseDto;
import com.springapp.financetracker.entity.Income;

import java.util.List;

public interface IncomeService {
    IncomeResponseDto addIncome(NewIncomePayload payload);
    IncomeResponseDto getIncome(Integer id);
    List<IncomeResponseDto> getAllIncome();
    IncomeResponseDto updateIncome(UpdateIncomePayload payload);
    void deleteIncome(Integer incomeId);
}
