package biz.galaxygroup.atn.mno.entities;


import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * 
 * @author blaise irakoze
 *
 */
@Entity
public class MnoProduct {
	@Id
	@Column(name = "id", length = 90)
	private String id;
	@ManyToOne
	@JoinColumn(name = "mno_profile_id", nullable = false)
	private MnoProfile mnoProfile;
	@ManyToOne
	@JoinColumn(name = "atn_product_id", nullable = false)
	private AtnProduct atnProduct;
	private Date creationTime;

	@PrePersist
	public void prepare() {
		this.creationTime = this.creationTime == null ? new Date() : this.creationTime;
		this.id = this.id == null ? UUID.randomUUID().toString() : this.id;
	}

	public MnoProduct() {
	}

	public MnoProduct(MnoProfile mnoProfile, AtnProduct atnProduct) {
		this.mnoProfile = mnoProfile;
		this.atnProduct = atnProduct;
	}

	public MnoProduct(MnoProfile mnoProfile, AtnProduct atnProduct, Date creationTime) {
		this.mnoProfile = mnoProfile;
		this.atnProduct = atnProduct;
		this.creationTime = creationTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MnoProfile getMnoProfile() {
		return mnoProfile;
	}

	public void setMnoProfile(MnoProfile mnoProfile) {
		this.mnoProfile = mnoProfile;
	}

	public AtnProduct getAtnProduct() {
		return atnProduct;
	}

	public void setAtnProduct(AtnProduct atnProduct) {
		this.atnProduct = atnProduct;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String toString() {
		return "MnoProduct{" +
				"id='" + id + '\'' +
				", mnoProfile=" + mnoProfile +
				", atnProduct=" + atnProduct +
				", creationTime=" + creationTime +
				'}';
	}
}
