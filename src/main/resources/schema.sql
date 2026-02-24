DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    owner_name VARCHAR(255) NOT NULL,
    balance DECIMAL(19,2) NOT NULL
);

INSERT INTO accounts (owner_name, balance) VALUES ('Alice Senior', 1000.00);
INSERT INTO accounts (owner_name, balance) VALUES ('Bob Junior', 500.00);
INSERT INTO accounts (owner_name, balance) VALUES ('Charlie Tester', 0.00);
åç
SELECT * FROM accounts;