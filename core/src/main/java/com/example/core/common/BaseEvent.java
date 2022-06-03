package com.example.core.common;

import lombok.Getter;
import org.springframework.util.Assert;

@Getter
public class BaseEvent<T>{

    private T id;

    public BaseEvent(T id) {
        Assert.notNull(id,"L'identifiant ne peut pas être null");
        this.id = id;
    }
}
