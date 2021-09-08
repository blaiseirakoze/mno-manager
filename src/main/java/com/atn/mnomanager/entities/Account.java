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
public class Account {
	@Id
	@Column(name = "id", length = 90)
	private String id;
	@Column(name = "accountTypeId", length = 90)
	private String accountTypeId;
	private Date creationTime;
	@Column(name = "status", length = 30)	
	private String status;
}
