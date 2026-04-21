package com.springapp.financetracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spending {
    private Integer id;
    private String name;
    private double amount;
}
