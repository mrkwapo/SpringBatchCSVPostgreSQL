DROP TABLE IF EXISTS state;
 
CREATE TABLE state  (
    id Bigserial PRIMARY KEY NOT NULL,
    city VARCHAR(20),
    abbr VARCHAR(20),
    name VARCHAR(20)
);