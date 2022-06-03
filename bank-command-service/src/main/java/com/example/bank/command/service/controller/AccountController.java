package com.example.bank.command.service.controller;

import com.example.bank.command.service.service.AccountService;
import com.example.core.bank.dto.AccountCreationDto;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/account")
@Api(value="Account commands")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    @PostMapping("/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public CompletableFuture<String> createAccount(AccountCreationDto dto){
        return accountService.createAccount(dto);
    }

}
