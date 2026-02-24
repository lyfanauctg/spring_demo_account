package com.example.demotransaction.service.impl;


import com.example.demotransaction.entity.model.Account;
import com.example.demotransaction.repository.AccountRepository;
import com.example.demotransaction.service.AccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;


    @Override
    @Transactional
    public void transfer(Long fromId, Long toId, double amount) {
        Account from = accountRepository.findById(fromId)
                .orElseThrow(() -> new RuntimeException("Account not found"));


        log.info("from Account {}" , fromId);

        Account to = accountRepository.findById(toId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        log.info("to Account: {}", toId);

        if(amount < 0){
            throw new RuntimeException("Amount should be greater than 0");
        }


        if(from.getBalance() < amount){
            throw new RuntimeException("Not enough balance");
        }

        log.info("Money before transfer: {}", from.getBalance());
        from.setBalance(from.getBalance() - amount);
        accountRepository.save(from);

        log.info("Money after exception occur: {}", from.getBalance());


        if (amount > 500){
            throw new RuntimeException("Roll back");
        }

        log.info("Money after rollback: {}", from.getBalance());

        to.setBalance(to.getBalance() + amount);

        accountRepository.save(to);

    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Account findAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found !!!"));
    }
}
