package com.example.core.bank.command;

import com.example.core.common.BaseCommand;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateAccountCommand extends BaseCommand<UUID> {

    private String customer;

    public CreateAccountCommand(UUID id, String customer) {
        super(id);
        this.customer = customer;
    }
}
