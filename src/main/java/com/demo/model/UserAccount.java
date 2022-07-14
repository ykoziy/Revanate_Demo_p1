package com.demo.model;

import java.util.Objects;

import com.revanate.annotations.Column;
import com.revanate.annotations.Entity;
import com.revanate.annotations.Id;

@Entity(tableName = "user_account")
public class UserAccount {
	
	@Id(columnName = "user_id", autoIndex = "auto")
	@Column(columnName = "user_id")
	private int userId;
	
	@Column(columnName = "user_name")
	private String username;
	
	@Column(columnName = "first_name")
	private String firstName;
	
	@Column(columnName = "last_name")
	private String lastName;
	
	@Column(columnName = "password")
	private String password;
	
	@Column(columnName = "email")
	private String email;

	public UserAccount(int userId, String username, String firstName, String lastName, String password, String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}

	public UserAccount(String username, String firstName, String lastName, String password, String email) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}

	public UserAccount() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, lastName, password, userId, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAccount other = (UserAccount) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& userId == other.userId && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", password=" + password + ", email=" + email + "]";
	}
}
