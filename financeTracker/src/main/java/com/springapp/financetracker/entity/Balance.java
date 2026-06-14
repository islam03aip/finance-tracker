package com.springapp.financetracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "transactions", name = "t_balance")
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "balance")
    private BigDecimal amount;

    @OneToOne
    @JoinColumn(name = "user_id")
    private CustomUser user;
}
