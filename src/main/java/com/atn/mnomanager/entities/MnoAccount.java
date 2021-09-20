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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMnoProfileId() {
		return mnoProfileId;
	}

	public void setMnoProfileId(String mnoProfileId) {
		this.mnoProfileId = mnoProfileId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public int getIsNormalAccount() {
		return isNormalAccount;
	}

	public void setIsNormalAccount(int isNormalAccount) {
		this.isNormalAccount = isNormalAccount;
	}

}
