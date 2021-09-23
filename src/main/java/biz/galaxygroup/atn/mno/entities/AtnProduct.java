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
public class AtnProduct {
    @Id
    @Column(name = "id", length = 90)
    private String id;
    @Column(name = "name", length = 90)
    private String name;
    private Date creationTime;
    @Column(name = "status", length = 30)
    private String status;

    @JsonIgnore
    @OneToMany(mappedBy = "atnProduct")
    private List<MnoProduct> mnoProducts;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<MnoProduct> getMnoProducts() {
        return mnoProducts;
    }

    public void setMnoProducts(List<MnoProduct> mnoProducts) {
        this.mnoProducts = mnoProducts;
    }

    @Override
    public String toString() {
        return "AtnProduct{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", creationTime=" + creationTime +
                ", status='" + status + '\'' +
                ", mnoProducts=" + mnoProducts +
                '}';
    }
}
