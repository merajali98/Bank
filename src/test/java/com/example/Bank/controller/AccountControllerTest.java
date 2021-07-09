package com.example.Bank.controller;


import com.example.Bank.dto.AccountDto;
import com.example.Bank.entity.Account;
import com.example.Bank.service.impl.AccountServiceImpl;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private AccountController accountController;

    @Mock
    private AccountServiceImpl accountService;

    @Test
    public void itShouldCreateUserAccount_WhenAccountDetailsIsProvided(){

        //Given
        AccountDto expectedResponseDto= AccountDto.builder().accountId(1L).accountNumber("1234").currentBalance(BigDecimal.valueOf(0)).build();

        //When
        Mockito.when(accountService.save(expectedResponseDto)).thenReturn(expectedResponseDto);


        //Then
        final ResponseEntity<AccountDto> actualResponseDto = accountController.createUserAccount(expectedResponseDto);

        Assert.assertEquals(expectedResponseDto,actualResponseDto.getBody());

    }
    @Test
    public void itShouldNotCreateUserAccount_WhenAccountDetailsIsNotProvided(){

        Mockito.when(accountService.save(null)).thenReturn(null);

        final ResponseEntity<AccountDto> actualResponse = accountController.createUserAccount(null);

        Assert.assertNull(actualResponse.getBody());

    }
}
