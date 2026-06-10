package com.springapp.financetracker.controller;

import com.springapp.financetracker.controller.payload.NewIncomePayload;
import com.springapp.financetracker.controller.payload.UpdateIncomePayload;
import com.springapp.financetracker.entity.Income;
import com.springapp.financetracker.service.income.IncomeService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("income")
@CrossOrigin(origins = "http://localhost:5173")
public class IncomeController {
    private final IncomeService incomeService;

    @GetMapping("/all")
    public Iterable<Income> getAllIncome(){
        return this.incomeService.getAllIncome();
    }

    @PostMapping("/add")
    public Income addIncome(@RequestBody NewIncomePayload payload){
        return this.incomeService.addIncome(payload);
    }

    @PostMapping("/update/{incomeId:\\d+}")
    public Income updateIncome(@RequestBody UpdateIncomePayload payload){
        return this.incomeService.updateIncome(payload);
    }

    @PostMapping("/delete/{incomeId:\\d+}")
    public void deleteIncome(@PathVariable  Integer incomeId){
        this.incomeService.deleteIncome(incomeId);
    }

    @GetMapping("/{incomeId:\\d+}")
    public Income getIncome(@PathVariable Integer incomeId){
        return this.incomeService.getIncome(incomeId);
    }
}
