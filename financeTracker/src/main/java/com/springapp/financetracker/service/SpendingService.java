package com.springapp.financetracker.service;

import com.springapp.financetracker.entity.Spending;

import java.util.List;

public interface SpendingService {
    List<Spending> getAllSpending();
}
