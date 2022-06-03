package com.example.bank.query.service.projection;

import com.example.bank.query.service.entity.Account;
import com.example.bank.query.service.repository.AccountRepository;
import com.example.core.bank.event.AccountCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class AccountProjection {

    private AccountRepository repository;

    @EventHandler
    public void on(AccountCreatedEvent event){
        log.info("Event projection  - Account Creation {}",event.getId());
        Account account = new Account();
        account.setId(event.getId());
        account.setCustomer((event.getCustomer()));
        repository.save(account);
    }
}
