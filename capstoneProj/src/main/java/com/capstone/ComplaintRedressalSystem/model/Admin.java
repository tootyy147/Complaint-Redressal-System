package com.capstone.ComplaintRedressalSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aid")
	private long id;
	
	@Column(name = "user_name")
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "soft_delete")
	private int softDelete;
	
	public Admin() {
		super();
	}

	public Admin(long id, String username, String emailId, String password, int softDelete) {
		super();
		this.id = id;
		this.username = username;
		this.emailId = emailId;
		this.password = password;
		this.softDelete = softDelete;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSoftDelete() {
		return softDelete;
	}

	public void setSoftDelete(int softDelete) {
		this.softDelete = softDelete;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", Username=" + username + ", emailId=" + emailId + ", password=" + password
				+ ", softDelete=" + softDelete + "]";
	}

}
