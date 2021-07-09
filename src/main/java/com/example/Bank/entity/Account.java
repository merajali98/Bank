package com.example.Bank.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Builder
@Data
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue
    private Long accountId;

    String accountNumber;

    BigDecimal currentBalance;

}