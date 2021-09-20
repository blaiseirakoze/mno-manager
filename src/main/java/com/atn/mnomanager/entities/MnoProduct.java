package com.atn.mnomanager.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
	@Column(name = "atnProductId", length = 90)
	private String atnProductId;
	@Column(name = "mnoProductId", length = 90)
	private String mnoProductId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAtnProductId() {
		return atnProductId;
	}

	public void setAtnProductId(String atnProductId) {
		this.atnProductId = atnProductId;
	}

	public String getMnoProductId() {
		return mnoProductId;
	}

	public void setMnoProductId(String mnoProductId) {
		this.mnoProductId = mnoProductId;
	}

}
