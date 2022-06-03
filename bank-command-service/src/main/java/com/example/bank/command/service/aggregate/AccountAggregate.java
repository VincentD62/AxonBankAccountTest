package com.example.bank.command.service.aggregate;

import com.example.core.bank.command.CreateAccountCommand;
import com.example.core.bank.event.AccountCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class AccountAggregate {

    @AggregateIdentifier
    private UUID id;
    private String customer;

    @CommandHandler
    public AccountAggregate(CreateAccountCommand command) {
        apply(new AccountCreatedEvent(
                command.getId(),
                command.getCustomer()
        ));

    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent event){
        this.id = event.getId();
        this.customer = event.getCustomer();
    }


}
