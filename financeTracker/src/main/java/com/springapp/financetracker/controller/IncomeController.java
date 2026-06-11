package com.springapp.financetracker.controller;

import com.springapp.financetracker.controller.payload.NewIncomePayload;
import com.springapp.financetracker.controller.payload.UpdateIncomePayload;
import com.springapp.financetracker.dto.IncomeResponseDto;
import com.springapp.financetracker.entity.Income;
import com.springapp.financetracker.service.income.IncomeService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("income")
@CrossOrigin(origins = "http://localhost:5173")
public class IncomeController {
    private final IncomeService incomeService;

    @GetMapping("/all")
    public ResponseEntity<List<IncomeResponseDto>> getAllIncome(){
        return ResponseEntity.ok(this.incomeService.getAllIncome());
    }

    @PostMapping("/add")
    public ResponseEntity<IncomeResponseDto> addIncome(@RequestBody NewIncomePayload payload){
        return ResponseEntity.ok(this.incomeService.addIncome(payload));
    }

    @PostMapping("/update/{incomeId:\\d+}")
    public ResponseEntity<IncomeResponseDto> updateIncome(@RequestBody UpdateIncomePayload payload){
        return ResponseEntity.ok(this.incomeService.updateIncome(payload));
    }

    @PostMapping("/delete/{incomeId:\\d+}")
    public void deleteIncome(@PathVariable  Integer incomeId){
        this.incomeService.deleteIncome(incomeId);
    }

    @GetMapping("/{incomeId:\\d+}")
    public ResponseEntity<IncomeResponseDto> getIncome(@PathVariable Integer incomeId){
        return ResponseEntity.ok(this.incomeService.getIncome(incomeId));
    }
}
