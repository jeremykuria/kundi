package com.kundi.kundi.service;

import com.kundi.kundi.domain.Account;
import com.kundi.kundi.domain.Member;
import com.kundi.kundi.domain.Transaction;
import com.kundi.kundi.domain.enumeration.TransactionType;
import com.kundi.kundi.repository.AccountRepository;
import com.kundi.kundi.repository.MemberRepository;
import com.kundi.kundi.repository.TransactionRepository;
import com.kundi.kundi.service.util.NotificationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

    private  final Logger log = LoggerFactory.getLogger(TransactionService.class);

    private final TransactionRepository transactionRepository;
    private  final AccountRepository accountRepository;
    private final NotificationUtil notificationUtil;
    private final MemberRepository memberRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountService accountService, AccountRepository accountRepository, NotificationUtil notificationUtil, MemberRepository memberRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.notificationUtil = notificationUtil;
        this.memberRepository = memberRepository;
    }


    public void save(Transaction transaction){
        log.info("saving transation: {}", transaction);

        transaction.setTransactionType(TransactionType.PAYMENT);
        transaction.setUuid(UUID.randomUUID().toString());
        transaction.setTransactionTime(LocalDate.now().toString());

        Transaction saveTransaction =  transactionRepository.save(transaction);

        //update account Balance.
        Optional<Account> account = this.accountRepository.findById(saveTransaction.getAccountId());

        account.get().setBalance(account.get().getBalance() + saveTransaction.getAmount());
        log.info("Account  To Adjust: {}", account);

        //this.accountRepository.save(account);

        //send Sms to member
        Optional<Member> member =  this.memberRepository.findById(transaction.getMemberId());

        log.info("Member Transacted: {}", member);
        this.notificationUtil.sendSMS(member.get().getPhoneNumber(),"Kundi: Contribution Payment Registered",saveTransaction.getReference());

    }

    public List<Transaction> filterTransation(Integer groupId, Integer memberId){
        return transactionRepository.findByGroupIdAndMemberId(groupId,memberId);
    }

}
