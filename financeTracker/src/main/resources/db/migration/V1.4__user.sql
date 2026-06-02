CREATE SCHEMA IF NOT EXISTS users;

CREATE EXTENSION IF NOT EXISTS citext;
CREATE DOMAIN email_address AS citext
CHECK (
    VALUE ~ '[a-zA-Z0-9.!#$%&''''*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$'
);

CREATE TABLE IF NOT EXISTS users.t_user(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    c_username VARCHAR(50) NOT NULL UNIQUE,
    c_email email_address NOT NULL UNIQUE,
    c_password VARCHAR(255) NOT NULL,
    c_created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE transactions.t_spending
ADD COLUMN user_id INTEGER REFERENCES users.t_user(id) ON DELETE CASCADE;