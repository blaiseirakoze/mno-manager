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
public class MnoProduct {
	@Id
	@Column(name = "id", length = 90)
	private String id;
	@Column(name = "atnProductId", length = 90)
	private String atnProductId;
	@Column(name = "mnoProductId", length = 90)
	private String mnoProductId;
}
