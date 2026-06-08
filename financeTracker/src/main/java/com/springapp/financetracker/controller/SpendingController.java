package com.springapp.financetracker.controller;

import com.springapp.financetracker.controller.payload.NewSpendingPayload;
import com.springapp.financetracker.controller.payload.UpdateSpendingPayload;
import com.springapp.financetracker.entity.Spending;
import com.springapp.financetracker.service.spending.SpendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("spending")
@CrossOrigin(origins = "http://localhost:5173")
public class SpendingController {
    private final SpendingService spendingService;

    @GetMapping("/all")
    public Iterable<Spending> getSpendingList(){
        return this.spendingService.getAllSpending();
    }

    @PostMapping("/create")
    public Spending createSpending(@RequestBody NewSpendingPayload payload){
        return spendingService.createSpending(payload);
    }

    @GetMapping("/{spendingId:\\d+}")
    public Spending getSpending(@PathVariable("spendingId") int spendingId){
        return this.spendingService.findSpending(spendingId).orElseThrow();
    }

    @PostMapping("/update/{spendingId:\\d+}")
    public void updateSpending(@PathVariable("spendingId") Integer spendingId, @RequestBody UpdateSpendingPayload payload){
        this.spendingService.updateSpending(spendingId, payload.name(), payload.amount(), payload.categoryId());
    }

    @PostMapping("/delete/{spendingId:\\d+}")
    public void deleteSpending(@PathVariable("spendingId") int spendingId) {
        this.spendingService.deleteSpending(spendingId);
    }


}
