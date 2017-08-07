package com.in28minutes.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
		@NamedQuery(name = "findUserByEmail", query = "SELECT u FROM User u where u.email = :p_email"),
		@NamedQuery(name = "findUserByEmailAndPassword", query = "SELECT u FROM User u where u.email = :p_email and u.password = :p_password") })
public class User implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String email;

	private String password;

	public User() {
	}

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format(
				"User [id=%s, items=%s, name=%s, email=%s, password=%s]", id,
				"", name, email, password);
	}
}
