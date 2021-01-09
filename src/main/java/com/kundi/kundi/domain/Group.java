package com.kundi.kundi.domain;

import com.kundi.kundi.domain.enumeration.GroupStatus;
import com.kundi.kundi.domain.enumeration.GroupType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name="tbl_groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private  String uuid;

    private String name;

    @Enumerated(EnumType.STRING)
    private GroupType type;

    @Email
    @Size(min = 5, max = 100)
    @Column(length = 100, unique = true)
    private String email;

    private  String phoneNumber;

    private String configs;

    @Enumerated(EnumType.STRING)
    private GroupStatus status;

    private LocalDate createdOn;

    private LocalDate updatedOn;

    private String createdBy;

    private String updatedBy;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupType getType() {
        return type;
    }

    public void setType(GroupType type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getConfigs() {
        return configs;
    }

    public void setConfigs(String configs) {
        this.configs = configs;
    }

    public GroupStatus getStatus() {
        return status;
    }

    public void setStatus(GroupStatus status) {
        this.status = status;
    }

    public LocalDate

    getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDate getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDate updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }


}
