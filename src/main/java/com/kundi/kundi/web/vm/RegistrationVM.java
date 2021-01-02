package com.kundi.kundi.web.vm;

import java.time.LocalDate;

public class RegistrationVM {

    private Integer id;
    private String fName;
    private String lName;
    private String email;
    private LocalDate dateOfBirth;
    private Long groupId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupIdId(Long countryId) {
        this.groupId = groupId;
    }
}
