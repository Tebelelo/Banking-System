package com.dekagoaytech.controller;

import com.dekagoaytech.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/deposit")
    public String deposit(@RequestParam long amount) {
        accountService.deposit(amount);
        return "Deposited: " + amount;
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam long amount) {
        accountService.withdraw(amount);
        return "Withdrew: " + amount;
    }

    @GetMapping("/balance")
    public String balance() {
        return "Available Balance: " + accountService.getBalance();
    }

    @GetMapping("/name")
    public String name() {
        return accountService.getAccountName();
    }
}
