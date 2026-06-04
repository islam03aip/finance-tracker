CREATE TABLE IF NOT EXISTS users.t_authority(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    c_authority VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS users.t_user_authority(
    user_id INTEGER NOT NULL REFERENCES users.t_user(id),
    authority_id INTEGER NOT NULL REFERENCES users.t_authority(id),
    CONSTRAINT uk_user_authority UNIQUE (user_id, authority_id)
);