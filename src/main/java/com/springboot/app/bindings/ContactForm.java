package com.springboot.app.bindings;



import java.util.Date;

import lombok.Data;


@Data
public class ContactForm {

	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	private String activeSw;
	private Date createdDate;
	private Date updatedDate;
}
