package com.kundi.kundi.repository;

import com.kundi.kundi.domain.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {

    List<Account> findByGroupId(Integer id);

}
