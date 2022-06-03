package com.example.core.common;


import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.springframework.util.Assert;

@Getter
public class BaseCommand<T> {

    @TargetAggregateIdentifier
    private T id;

    public BaseCommand(T id) {
        Assert.notNull(id,"L'identifiant ne peut pas être null");
        this.id = id;
    }

}
