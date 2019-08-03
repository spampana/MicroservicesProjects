package com.helpezee.services.commands;

import java.util.concurrent.CompletableFuture;

import com.helpezee.dto.commands.AccountCreateDTO;
import com.helpezee.dto.commands.MoneyCreditDTO;
import com.helpezee.dto.commands.MoneyDebitDTO;

public interface AccountCommandService {

    public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO);
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO);
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO);
}
