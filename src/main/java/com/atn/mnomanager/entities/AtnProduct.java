package com.atn.mnomanager.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author blaise irakoze
 *
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

}
