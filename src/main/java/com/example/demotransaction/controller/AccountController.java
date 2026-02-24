package com.example.demotransaction.controller;

import com.example.demotransaction.entity.model.Account;
import com.example.demotransaction.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/transfer")
    public String transfer(@RequestParam Long fromId, @RequestParam Long toId, @RequestParam double amount){
        accountService.transfer(fromId,toId,amount);
        return "Transfer Successfully !!!";
    }

    @GetMapping("/all")
    public List<Account> getAllAccount(){
        return accountService.getAllAccount();
    }


}
