package com.springapp.financetracker.repository;

import com.springapp.financetracker.entity.Spending;

import java.util.List;

public interface SpendingRepository {
    List<Spending> getAll();
}
