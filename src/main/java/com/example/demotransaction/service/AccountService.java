package com.example.demotransaction.service;


import com.example.demotransaction.entity.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    void transfer(Long fromId, Long toId, double amount);

    List<Account> getAllAccount();
}
