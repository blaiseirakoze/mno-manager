package com.atn.mnomanager.entities;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author blaise irakoze
 */
@Entity
public class MnoAccount {
    @Id
    @Column(name = "id", length = 90)
    private String id = UUID.randomUUID().toString();
    private int isNormalAccount;

    @ManyToOne
    @JoinColumn(name = "mno_profile_id", nullable = false)
    private MnoProfile mnoProfile;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public MnoAccount() {
    }

    public MnoAccount(int isNormalAccount, MnoProfile mnoProfile, Account account) {
        this.isNormalAccount = isNormalAccount;
        this.mnoProfile = mnoProfile;
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIsNormalAccount() {
        return isNormalAccount;
    }

    public void setIsNormalAccount(int isNormalAccount) {
        this.isNormalAccount = isNormalAccount;
    }

    public MnoProfile getMnoProfile() {
        return mnoProfile;
    }

    public void setMnoProfile(MnoProfile mnoProfile) {
        this.mnoProfile = mnoProfile;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
