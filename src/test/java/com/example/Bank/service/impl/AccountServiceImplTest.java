package com.example.Bank.service.impl;


import com.example.Bank.Repository.AccountRepository;
import com.example.Bank.entity.Account;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;

    @Test
    public void itShouldCreateAccount_WhenAccountDetailsIsProvided(){

        Account expectedResponse= Account.builder().accountId(1L).accountNumber("1234").currentBalance(BigDecimal.valueOf(0)).build();

        Mockito.when(accountRepository.save(expectedResponse)).thenReturn(expectedResponse);
        final Account actualResponse = accountService.save(Account.builder().accountId(1L).accountNumber("1234").currentBalance(BigDecimal.valueOf(0)).build());

        Assert.assertEquals(expectedResponse,actualResponse);


    }
    @Test
    public void itShouldNotCreateAccount_WhenAccountDetailsIsNotProvided(){


        Mockito.when(accountRepository.save(null)).thenReturn(null);
        final Account actualResponse = accountService.save(null);

        Assert.assertNull(actualResponse);


    }

}
