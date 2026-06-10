package com.springapp.financetracker.service.income;

import com.springapp.financetracker.controller.payload.NewIncomePayload;
import com.springapp.financetracker.controller.payload.UpdateIncomePayload;
import com.springapp.financetracker.entity.Income;

public interface IncomeService {
    Income addIncome(NewIncomePayload payload);
    Income getIncome(Integer id);
    Iterable<Income> getAllIncome();
    Income updateIncome(UpdateIncomePayload payload);
    void deleteIncome(Integer incomeId);
}
