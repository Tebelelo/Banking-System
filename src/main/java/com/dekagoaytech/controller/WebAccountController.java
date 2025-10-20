package com.dekagoaytech.controller;

import com.dekagoaytech.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebAccountController {

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/create-account")
    public String createAccount(@RequestParam String accountType,
                                @RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam String email,
                                @RequestParam String phone,
                                @RequestParam String dob,
                                @RequestParam String ssn,
                                @RequestParam String address,
                                @RequestParam String city,
                                @RequestParam String state,
                                @RequestParam String zip,
                                @RequestParam long initialDeposit,
                                Model model) {

        Account account;

        switch (accountType.toLowerCase()) {
            case "savings":
                account = new SavingsAccount();
                break;
            case "credit":
                account = new CreditAccount();
                break;
            case "debit":
                account = new DebitAccount();
                break;
            case "business":
                account = new BusinessAccount();
                break;
            default:
                model.addAttribute("message", "Invalid account type.");
                return "index";
        }

        account.deposit(new Money(initialDeposit));


        model.addAttribute("message", "Account created: " + account.accountName());
        model.addAttribute("balance", account.getAvailableBalance().toDisplayInRands());

        return "success";
    }
}
