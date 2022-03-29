CREATE TABLE IF NOT EXISTS users (
    id serial NOT NULL,
    name VARCHAR(255),
    icon VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    PRIMARY KEY (id)
)