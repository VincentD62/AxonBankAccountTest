package com.example.core.bank.event;

import com.example.core.common.BaseEvent;
import lombok.Getter;

import java.util.UUID;

@Getter
public class AccountCreatedEvent extends BaseEvent<UUID> {
    private final String customer;

    public AccountCreatedEvent(UUID id, String customer) {
        super(id);
        this.customer = customer;
    }
}
