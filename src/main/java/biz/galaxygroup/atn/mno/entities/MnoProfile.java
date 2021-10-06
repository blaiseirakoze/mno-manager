package biz.galaxygroup.atn.mno.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

/**
 * @author blaise irakoze
 */
@Entity
public class MnoProfile {
    @Id
    @Column(name = "id", length = 90)
    private String id;
    @Column(name = "name", length = 90)
    private String name;
    @Column(name = "email", length = 60)
    private String email;
    @Column(name = "telephone", length = 30)
    private String telephone;
    @Column(columnDefinition = "TEXT")
    private String agentConfig;
    private Date creationTime;
    @Column(name = "status", length = 30)
    private String status;
//    @Index
    @Column(columnDefinition = "TEXT", name = "search_by")
    private String searchBy;

    @JsonIgnore
    @OneToMany(mappedBy = "mnoProfile")
    private List<MnoProduct> mnoProducts;

    @JsonIgnore
    @OneToMany(mappedBy = "mnoProfile")
    private List<MnoAccount> mnoAccounts;

    @PrePersist
    public void prepare() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.creationTime = this.creationTime == null ? new Date() : this.creationTime;
        this.id = this.id == null ? UUID.randomUUID().toString() : this.id;
        this.searchBy = this.name + "," + this.email + "," + this.telephone + "," + this.agentConfig + "," + format.format(this.creationTime) + "," + this.status;
    }

    public MnoProfile() {
    }

    public MnoProfile(String name, String email, String telephone, String agentConfig, String status) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.agentConfig = agentConfig;
        this.status = status;
    }

    public MnoProfile(String name, String email, String telephone, String agentConfig, Date creationTime, String status) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.agentConfig = agentConfig;
        this.creationTime = creationTime;
        this.status = status;
    }

    public MnoProfile(String id, String name, String email, String telephone, String agentConfig, Date creationTime, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.agentConfig = agentConfig;
        this.creationTime = creationTime;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAgentConfig() {
        return agentConfig;
    }

    public void setAgentConfig(String agentConfig) {
        this.agentConfig = agentConfig;
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

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }

    public List<MnoProduct> getMnoProducts() {
        return mnoProducts;
    }

    public void setMnoProducts(List<MnoProduct> mnoProducts) {
        this.mnoProducts = mnoProducts;
    }

    public List<MnoAccount> getMnoAccounts() {
        return mnoAccounts;
    }

    public void setMnoAccounts(List<MnoAccount> mnoAccounts) {
        this.mnoAccounts = mnoAccounts;
    }

    @Override
    public String toString() {
        return "MnoProfile{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", agentConfig='" + agentConfig + '\'' +
                ", creationTime=" + creationTime +
                ", status='" + status + '\'' +
                '}';
    }
}
