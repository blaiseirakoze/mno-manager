package biz.galaxygroup.atn.mno.entities;

import javax.persistence.*;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

/**
 * @author blaise irakoze
 */
@Entity
@Table(indexes = {@Index(name = "searchBy", columnList = "searchBy")})
public class MnoAccount {
    @Id
    @Column(name = "id", length = 90)
    private String id;
    private int isNormalAccount;
    private Date creationTime;
    @Column(name = "searchBy", length = 60)
    private String searchBy;

    @ManyToOne
    @JoinColumn(name = "mno_profile_id", nullable = false)
    private MnoProfile mnoProfile;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @PrePersist
    public void prepare() {
        this.creationTime = this.creationTime == null ? new Date() : this.creationTime;
        this.id = this.id == null ? UUID.randomUUID().toString() : this.id;
        this.searchBy = this.isNormalAccount + "," + this.creationTime;
    }

    @PreUpdate
    public void update() throws ParseException {
        this.searchBy = this.isNormalAccount + "," + this.creationTime;
    }

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

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }
}
