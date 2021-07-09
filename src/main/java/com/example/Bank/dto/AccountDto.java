package com.example.Bank.dto;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class AccountDto {

    private Long accountId;

    private String accountNumber;

    private BigDecimal currentBalance;

}
