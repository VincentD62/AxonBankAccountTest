package com.example.bank.query.service.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name="ACCOUNT")
public class Account {

    @Id
    @Type(type="uuid-char")
    private UUID id;
    private String Customer;
    private Double Balance;
}
