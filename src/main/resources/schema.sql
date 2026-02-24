DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    owner_name VARCHAR(255) NOT NULL,
    balance DECIMAL(19,2) NOT NULL
);

INSERT INTO accounts (accounts.owner_name, accounts.balance) VALUES ('Alice Senior', 1000.00);
INSERT INTO accounts (accounts.owner_name, accounts.balance) VALUES ('Bob Junior', 500.00);
INSERT INTO accounts (accounts.owner_name, accounts.balance) VALUES ('Charlie Tester', 0.00);

SELECT * FROM accounts;