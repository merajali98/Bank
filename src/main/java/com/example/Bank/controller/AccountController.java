package com.example.Bank.controller;

import com.example.Bank.dto.AccountDto;
import com.example.Bank.entity.Account;
import com.example.Bank.service.AccountService;
import org.modelmapper.ModelMapper;
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
    private ModelMapper modelMapper;

    @Autowired
    private AccountService accountService;

    @PostMapping("/createAccount")
    public ResponseEntity<AccountDto> createUserAccount(@RequestBody AccountDto accountDto){

        Account userAccountCreatedResponse = accountService.save(modelMapper.map(accountDto,Account.class));

        return ResponseEntity.ok(modelMapper.map(userAccountCreatedResponse,AccountDto.class));

    }

}
