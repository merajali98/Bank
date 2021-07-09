package com.example.Bank.controller;


import com.example.Bank.entity.Account;
import com.example.Bank.service.impl.AccountServiceImpl;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {


    @InjectMocks
    private AccountController accountController;

    @Mock
    private AccountServiceImpl accountService;

    @Test
    public void itShouldCreateUserAccount_WhenAccountDetailsIsProvided(){
        Account expectedResponse= Account.builder().accountId(1L).accountNumber("1234").currentBalance(BigDecimal.valueOf(0)).build();

        Mockito.when(accountService.save(expectedResponse)).thenReturn(expectedResponse);
        final ResponseEntity<Account> actualResponse = accountController.createUserAccount(Account.builder().accountId(1L).accountNumber("1234").currentBalance(BigDecimal.valueOf(0)).build());

        Assert.assertEquals(expectedResponse,actualResponse.getBody());

    }
    @Test
    public void itShouldNotCreateUserAccount_WhenAccountDetailsIsNotProvided(){

        Mockito.when(accountService.save(null)).thenReturn(null);
        final ResponseEntity<Account> actualResponse = accountController.createUserAccount(null);

        Assert.assertNull(actualResponse.getBody());

    }
}
