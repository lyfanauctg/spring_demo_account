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

        from.setBalance(1000.00);

        log.info("from Account {}" , fromId);

        Account to = accountRepository.findById(toId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        log.info("to Account: {}", toId);

        if(from.getBalance() < amount){
            throw new RuntimeException("Not enough balance");
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        accountRepository.save(from);
        accountRepository.save(to);

    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }
}
