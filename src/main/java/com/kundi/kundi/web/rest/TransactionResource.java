package com.kundi.kundi.web.rest;

import com.kundi.kundi.domain.Transaction;
import com.kundi.kundi.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transations")
public class TransactionResource {

    private  final Logger log = LoggerFactory.getLogger(TransactionResource.class);

    private TransactionService transactionService;

    public TransactionResource(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/save")
    public void saveTransation(@RequestBody Transaction transaction){
        log.info("Request to save TRansaction: {}", transaction);
        this.transactionService.save(transaction);
    }

    @GetMapping("/{groupId}/{memberId}")
    public void getTransactions(Integer groupId, Integer memberId){
        this.transactionService.filterTransation(groupId,memberId);
    }
}
