package com.springboot.app.entities;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "ContactTable")
@Data
public class Contact {

	@Id
	@GeneratedValue
	@Column(name = "ContactID")
	private Integer contactId;

	@Column(name = "ContactName")
	private String contactName;

	@Column(name = "ContactEmail")
	private String contactEmail;

	@Column(name = "ContactNumber")
	private Long contactNumber;

	@Column(name = "ActiveSw")
	private String Activesw;

	@Column(name = "CreatedDate")
	@CreationTimestamp
	private Date createdDate;

	@Column(name = "UpdatedDate")
	@UpdateTimestamp
	private Date updatedDate;

}
