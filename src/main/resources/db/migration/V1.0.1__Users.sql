CREATE TABLE IF NOT EXISTS users (
    id serial NOT NULL,
    name VARCHAR(255),
    url VARCHAR(2100),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    PRIMARY KEY (id)
)