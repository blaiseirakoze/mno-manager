package com.atn.mnomanager.entities;


import javax.persistence.*;
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
	private String id = UUID.randomUUID().toString();
	@ManyToOne
	@JoinColumn(name = "mno_profile_id", nullable = false)
	private MnoProfile mnoProfile;
	@ManyToOne
	@JoinColumn(name = "atn_product_id", nullable = false)
	private AtnProduct atnProduct;

	public MnoProduct() {
	}

	public MnoProduct(MnoProfile mnoProfile, AtnProduct atnProduct) {
		this.mnoProfile = mnoProfile;
		this.atnProduct = atnProduct;
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

	@Override
	public String toString() {
		return "MnoProduct{" +
				"id='" + id + '\'' +
				", mnoProfile=" + mnoProfile +
				", atnProduct=" + atnProduct +
				'}';
	}
}
