package com.example.bank.query.service.controller;

import com.example.core.bank.dto.AccountDto;
import com.example.core.bank.query.FindAccountById;
import com.example.core.bank.query.GetAllAccountsQuery;
import com.example.core.common.ServiceUtils;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/account")
@Api(value="Account queries")
@AllArgsConstructor
public class AccountQueryController {

    private QueryGateway queryGateway;

    @GetMapping()
    public CompletableFuture<List<AccountDto>> listOfAccount(){
        return queryGateway.query(
                new GetAllAccountsQuery(),
                ResponseTypes.multipleInstancesOf(AccountDto.class)
        );
    }

    @GetMapping("/{id}")
    public CompletableFuture<AccountDto> searchAccount(@PathVariable(name="id") String id){
        return queryGateway.query(
                new FindAccountById(ServiceUtils.formatUuid(id)),
                ResponseTypes.instanceOf(AccountDto.class)
        );
    }


}
