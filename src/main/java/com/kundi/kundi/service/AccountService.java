package com.kundi.kundi.service;

import com.kundi.kundi.domain.Account;
import com.kundi.kundi.domain.AccountStatement;
import com.kundi.kundi.repository.AccountRepository;
import com.kundi.kundi.repository.AccountStatementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    private final Logger log = LoggerFactory.getLogger(AccountService.class);

    private final AccountRepository accountRepository;
    private final AccountStatementRepository accountStatementRepository;


    public AccountService(AccountRepository accountRepository, AccountStatementRepository accountStatementRepository) {
        this.accountRepository = accountRepository;
        this.accountStatementRepository = accountStatementRepository;
    }


    public List<Account> getGroupAccounts(Integer groupId){
        log.info("Getting Accounts for Group: {}", groupId);

        return this.accountRepository.findByGroupId(groupId);
    }

    public Account addGroupAccount(Account account){

       return this.accountRepository.save(account);

    }


    public Optional<Account> getAccountById(Long accountId) {

        return this.accountRepository.findById(accountId);
    }

    public Account updateAccountBalance(Long accountId, double amount) {

        Optional<Account> account = getAccountById(accountId);

        log.info("About to update Account Transacted:" + account.get().getId() + "current balance " + account.get().getBalance());


        AccountStatement statement = new AccountStatement();

        statement.setBalanceBefore(account.get().getBalance());
        statement.setBalanceAfter(account.get().getBalance() + amount);
        statement.setAccountId(account.get().getId());
        statement.setGroupId(account.get().getGroupId());
        statement.setCreatedOn(Instant.now());
        statement.setUuid(UUID.randomUUID().toString());

        log.info("Generated Statement:" +"|account" +account.get().getId() +"|statement" + statement);

        this.accountStatementRepository.save(statement);

        log.info("Saved Statement:" +"|account" +account.get().getId() +"|statement" + statement.getId());

        account.get().setBalance(account.get().getBalance() + amount);

        log.info("About to update Account Transacted: new balance " + account.get().getBalance());


        return accountRepository.save(account.get());


    }


}
