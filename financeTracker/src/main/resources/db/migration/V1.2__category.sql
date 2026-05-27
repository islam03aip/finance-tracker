CREATE TABLE  IF NOT EXISTS transactions.t_category(
    id SERIAL PRIMARY KEY,
    c_name VARCHAR(100) NOT NULL UNIQUE DEFAULT 'None'
);

ALTER TABLE IF EXISTS transactions.t_spending
ADD COLUMN category_id INTEGER REFERENCES transactions.t_category(id);
