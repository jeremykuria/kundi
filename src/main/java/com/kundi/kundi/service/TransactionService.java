package com.kundi.kundi.service;

import com.kundi.kundi.domain.Group;
import com.kundi.kundi.domain.Transaction;
import com.kundi.kundi.repository.TransactionRepository;
import com.kundi.kundi.web.rest.TransactionResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionService {

    private  final Logger log = LoggerFactory.getLogger(TransactionService.class);


    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction save(Transaction transaction){
        log.info("saving transation: {}", transaction);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> filterTransation(Integer groupId, Integer memberId){
        return transactionRepository.findByGroupIdAndMemberId(groupId,memberId);
    }

}
