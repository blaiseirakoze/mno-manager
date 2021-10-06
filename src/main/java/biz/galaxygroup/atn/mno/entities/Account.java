package biz.galaxygroup.atn.mno.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

/**
 * @author blaise irakoze
 */
@Entity
public class Account {
    @Id
    @Column(name = "id", length = 90)
    private String id;
    @Column(name = "accountTypeId", length = 90)
    private String accountTypeId;
    private Date creationTime;
    @Column(name = "status", length = 30)
    private String status;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<MnoAccount> mnoAccounts;

    @PrePersist
    public void prepare() {
        this.creationTime = this.creationTime == null ? new Date() : this.creationTime;
        this.id = this.id == null ? UUID.randomUUID().toString() : this.id;
    }

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
