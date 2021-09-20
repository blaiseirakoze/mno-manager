package com.atn.mnomanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author blaise irakoze
 */
@Entity
public class Account {
    @Id
    @Column(name = "id", length = 90)
    private String id = UUID.randomUUID().toString();
    @Column(name = "accountTypeId", length = 90)
    private String accountTypeId;
    private Date creationTime;
    @Column(name = "status", length = 30)
    private String status;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<MnoAccount> mnoAccounts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(String accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", accountTypeId='" + accountTypeId + '\'' +
                ", creationTime=" + creationTime +
                ", status='" + status + '\'' +
                '}';
    }
}
