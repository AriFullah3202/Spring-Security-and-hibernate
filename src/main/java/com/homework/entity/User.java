package com.homework.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "user", schema = "Human")
public class User {
	@Id
	@NotEmpty(message =" * user name can not be null")
	private String userName;
	@Column
	@Size(min = 8 ,message ="* password should be at least 8 character")
	private String password;
	@Email
	@Column
	private String email;
	@NotEmpty(message = "* first name can not be empty")
	@Column
	private String firstName;
	@NotEmpty(message = "* last name can not be empty")
	@Column
	private String lastName;
	
	@Column
	private String roles = "admin";
	@Type(type = "numeric_boolean")
	@Column(name = "enabled")
	private boolean enabled;

	
	
	
	
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	
//	@Override
//	public String toString() {
//		return "UserInfoDTO [userName=" + userName + ", password=" + password + ", email=" + email + ", firstName="
//				+ firstName + ", lastName=" + lastName + "]";
//	}
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
