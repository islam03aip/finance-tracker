package com.springapp.financetracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "users", name = "t_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_username", nullable = false, unique = true)
    private String username;

    @Column(name = "c_email", nullable = false, unique = true)
    private String email;

    @Column(name = "c_password", nullable = false)
    private String password;

    @Column(name = "c_created_at", nullable = false)
    private LocalDateTime createdAt;
}
