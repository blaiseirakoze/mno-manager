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
public class MnoAccount {
	@Id
	@Column(name = "id", length = 90)
	private String id;
	@Column(name = "mnoProfileId", length = 90)
	private String mnoProfileId;
	@Column(name = "accountId", length = 90)
	private String accountId;
	private int isNormalAccount;
	
}
