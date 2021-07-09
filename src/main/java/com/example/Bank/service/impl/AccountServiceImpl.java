package com.example.Bank.service.impl;

import com.example.Bank.Repository.AccountRepository;
import com.example.Bank.entity.Account;
import com.example.Bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account save(Account account) {

        return accountRepository.save(account);
    }
}
