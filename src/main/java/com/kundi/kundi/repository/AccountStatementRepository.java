package com.kundi.kundi.repository;

import com.kundi.kundi.domain.Account;
import com.kundi.kundi.domain.AccountStatement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountStatementRepository extends CrudRepository<AccountStatement, Long> {

    List<AccountStatement> findByAccountId(Integer id);


}
