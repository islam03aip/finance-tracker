package com.springapp.financetracker.controller;

import com.springapp.financetracker.controller.payload.NewSpendingPayload;
import com.springapp.financetracker.controller.payload.UpdateSpendingPayload;
import com.springapp.financetracker.dto.SpendingResponseDto;
import com.springapp.financetracker.entity.Spending;
import com.springapp.financetracker.service.spending.SpendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("spending")
@CrossOrigin(origins = "http://localhost:5173")
public class SpendingController {
    private final SpendingService spendingService;

    @GetMapping("/all")
    public ResponseEntity<List<SpendingResponseDto>> getSpendingList(){
        return ResponseEntity.ok(spendingService.getAllSpending());
    }

    @PostMapping("/create")
    public ResponseEntity<SpendingResponseDto> createSpending(@RequestBody NewSpendingPayload payload){
        return spendingService.createSpending(payload);
    }

    @GetMapping("/{spendingId:\\d+}")
    public ResponseEntity<SpendingResponseDto> getSpending(@PathVariable("spendingId") int spendingId){
        return this.spendingService.findSpending(spendingId);
    }

    @PostMapping("/update/{spendingId:\\d+}")
    public void updateSpending(@PathVariable("spendingId") Integer spendingId, @RequestBody UpdateSpendingPayload payload){
        this.spendingService.updateSpending(spendingId, payload.name(), payload.amount(), payload.categoryId());
    }

    @PostMapping("/delete/{spendingId:\\d+}")
    public void deleteSpending(@PathVariable("spendingId") int spendingId) {
        this.spendingService.deleteSpending(spendingId);
    }

    @GetMapping("/all/category/{categoryId:\\d+}")
    public ResponseEntity<List<SpendingResponseDto>> getSpendingsByCategory(Integer categoryId){
        return ResponseEntity.ok(this.spendingService.getSpendingsByCategory(categoryId));
    }

}
