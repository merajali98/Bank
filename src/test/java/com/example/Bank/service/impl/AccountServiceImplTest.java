package com.example.Bank.service.impl;


import com.example.Bank.Repository.AccountRepository;
import com.example.Bank.dto.AccountDto;
import com.example.Bank.entity.Account;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;

    @Test
    public void itShouldCreateAccount_WhenAccountDetailsIsProvided(){

        AccountDto expectedResponseDto= AccountDto.builder().accountNumber("1234").currentBalance(BigDecimal.valueOf(0)).build();
        Account expectedResponse=modelMapper.map(expectedResponseDto,Account.class);

        Mockito.when(accountRepository.save(modelMapper.map(expectedResponseDto,Account.class))).thenReturn(expectedResponse);
        Mockito.when(modelMapper.map(expectedResponse,AccountDto.class)).thenReturn(expectedResponseDto);

        final AccountDto actualResponseDto = accountService.save(expectedResponseDto);

        Assert.assertEquals(expectedResponseDto,actualResponseDto);


    }
    @Test
    public void itShouldNotCreateAccount_WhenAccountDetailsIsNotProvided(){


        Mockito.when(accountRepository.save(null)).thenReturn(null);
        final AccountDto actualResponseDto = accountService.save(null);

        Assert.assertNull(actualResponseDto);


    }

}
