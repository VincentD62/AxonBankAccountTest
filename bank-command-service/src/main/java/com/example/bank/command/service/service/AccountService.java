package com.example.bank.command.service.service;

import com.example.core.bank.command.CreateAccountCommand;
import com.example.core.bank.dto.AccountCreationDto;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class AccountService {

    private CommandGateway commandGateway;

    public CompletableFuture<String> createAccount(AccountCreationDto dto){
        return commandGateway.send(new CreateAccountCommand(
               UUID.randomUUID(),
               dto.getCustomer()
        ));
    }

}
