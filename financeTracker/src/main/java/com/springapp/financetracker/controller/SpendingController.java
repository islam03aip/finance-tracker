package com.springapp.financetracker.controller;

import com.springapp.financetracker.controller.payload.NewSpendingPayload;
import com.springapp.financetracker.entity.Spending;
import com.springapp.financetracker.service.SpendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("spending")
@CrossOrigin(origins = "http://localhost:5173")
public class SpendingController {
    private final SpendingService spendingService;

    @GetMapping("/all")
    public List<Spending> getSpendingList(){
        return this.spendingService.getAllSpending();
    }

//    @PostMapping("/create")
//    public Spending createSpending(@RequestBody Spending spending){
//        return spendingService.save(spending);
//    }
}
