package com.kundi.kundi.repository;

import com.kundi.kundi.domain.Transaction;
import com.kundi.kundi.domain.enumeration.TransactionStatus;
import com.kundi.kundi.domain.enumeration.TransactionType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

    List<Transaction> findByGroupIdAndMemberId(Integer groupId, Integer memberId);

}
