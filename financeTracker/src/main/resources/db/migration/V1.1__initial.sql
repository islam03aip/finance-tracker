CREATE SCHEMA IF NOT EXISTS transactions;

CREATE TABLE IF NOT EXISTS transactions.t_spending (
    id SERIAL PRIMARY KEY,
    c_name VARCHAR(100) NOT NULL,
    c_amount NUMERIC(19, 2) NOT NULL
);