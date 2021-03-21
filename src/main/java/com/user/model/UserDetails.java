package com.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="user_dtl_tbl")
@Data
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer id;
	
	@Size(min=2,message="First name atleast have minimum two character")
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="role")
	private String role;
	
	@NotEmpty(message="Username is mandatory ,Please provide username")
	@Column(name="username")
	private String userName;
	
	@Column(name="email")
	private String emailId;
	
	
	
}
