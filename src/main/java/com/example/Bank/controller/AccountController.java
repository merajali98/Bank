package com.example.Bank.controller;

import com.example.Bank.entity.Account;
import com.example.Bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/createAccount")
    public ResponseEntity<Account> createUserAccount(@RequestBody Account account){

        return ResponseEntity.ok(accountService.save(account));

    }

}
