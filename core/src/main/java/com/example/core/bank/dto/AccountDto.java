package com.example.core.bank.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AccountDto {

    private UUID id;
    private String customer;

}
