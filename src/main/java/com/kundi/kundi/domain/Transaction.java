package com.kundi.kundi.domain;

import com.kundi.kundi.domain.enumeration.TransationMethod;
import com.kundi.kundi.domain.enumeration.TransactionStatus;
import com.kundi.kundi.domain.enumeration.TransactionType;

import javax.persistence.*;

@Entity
@Table(name = "tbl_transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;

    private  String uuid;

    private String transactionTime;

    private double amount;

    private String reference;

    private String configs;

    private String reason;

    private Integer memberId;

    private Long groupId;


    @Enumerated(EnumType.STRING)
    private TransationMethod method;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private Long accountId;

    private String mac;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getConfigs() {
        return configs;
    }

    public void setConfigs(String configs) {
        this.configs = configs;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public TransationMethod getMethod() {
        return method;
    }

    public void setMethod(TransationMethod method) {
        this.method = method;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", transactionTime=" + transactionTime +
                ", amount=" + amount +
                ", reference='" + reference + '\'' +
                ", configs='" + configs + '\'' +
                ", reason='" + reason + '\'' +
                ", memberId=" + memberId +
                ", groupId=" + groupId +
                ", method=" + method +
                ", status=" + status +
                ", transactionType=" + transactionType +
                ", accountId=" + accountId +
                ", mac='" + mac + '\'' +
                '}';
    }
}
