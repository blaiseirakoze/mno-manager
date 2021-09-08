package com.atn.mnomanager.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author blaise irakoze
 *
 */
@Entity
public class MnoProfile {
	@Id
	@Column(name = "id", length = 90)
	private String id = UUID.randomUUID().toString();
	@Column(name = "name", length = 90)
	private String name;
	@Column(name = "email", length = 60)
	private String email;
	@Column(name = "telephone", length = 30)	
	private String telephone;
	private String agentConfig;
	private Date creationTime;
	@Column(name = "status", length = 30)	
	private String status;
}
