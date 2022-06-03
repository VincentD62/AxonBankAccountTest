package com.example.bank.query.service.service;

import com.example.bank.query.service.entity.Account;
import com.example.bank.query.service.repository.AccountRepository;
import com.example.core.bank.dto.AccountDto;
import com.example.core.bank.query.FindAccountById;
import com.example.core.bank.query.GetAllAccountsQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class AccountQueryService {

    private AccountRepository repository;

    @QueryHandler
    public List<AccountDto> handle (GetAllAccountsQuery query){
        log.info("Query -  Get All Account: {}",query);
        return convertToListDto(repository.findAll());
    }

    @QueryHandler
    public <Optional>AccountDto handle (FindAccountById query){
        log.info("Query -  Find one Account: {}",query);
        return convertToDto(repository.findById(query.getId())
                .orElseThrow(()-> new RuntimeException("Account n'existe pas !"))
        );
    }

    private List<AccountDto> convertToListDto(List<Account> accounts){
        List<AccountDto> dtos = new ArrayList<>();
        for (Account account: accounts){
            AccountDto dto = new AccountDto();
            dto.setId(account.getId());
            dto.setCustomer(account.getCustomer());
            dtos.add(dto);
        }
        return dtos;
    }

    private AccountDto convertToDto(Account account){
        AccountDto dto = new AccountDto();
        dto.setId(account.getId());
        dto.setCustomer(account.getCustomer());
        return dto;
    }

}
