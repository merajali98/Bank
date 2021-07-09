package com.example.Bank.service.impl;

import com.example.Bank.Repository.AccountRepository;
import com.example.Bank.dto.AccountDto;
import com.example.Bank.entity.Account;
import com.example.Bank.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto save(AccountDto accountdto) {

        Account account = accountRepository.save(modelMapper.map(accountdto, Account.class));

        return modelMapper.map(account,AccountDto.class);
    }
}
