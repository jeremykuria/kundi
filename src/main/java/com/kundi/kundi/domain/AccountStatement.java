package com.kundi.kundi.domain;

import com.kundi.kundi.domain.enumeration.TransactionStatus;
import com.kundi.kundi.domain.enumeration.TransactionType;
import com.kundi.kundi.domain.enumeration.TransationMethod;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tbl_account_statements")
public class AccountStatement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;

    private  String uuid;

    private Instant createdOn;

    private double balanceBefore;

    private double balanceAfter;

    private String reference;

    private String configs;

    private String reason;

    private Integer memberId;

    private Integer groupId;


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

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public double getBalanceBefore() {
        return balanceBefore;
    }

    public void setBalanceBefore(double balanceBefore) {
        this.balanceBefore = balanceBefore;
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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
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

    public double getBalanceAfter() {
        return balanceAfter;
    }

    public void setBalanceAfter(double balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    @Override
    public String toString() {
        return "AccountStatement{" +
            "id=" + id +
            ", uuid='" + uuid + '\'' +
            ", createdOn='" + createdOn + '\'' +
            ", balanceBefore=" + balanceBefore +
            ", balanceAfter=" + balanceAfter +
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
