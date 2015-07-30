package com.endava.myapp.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="users")
public class UserDAO implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column (name="username", nullable=false)
	private String username;
	
	@Column (name="password", nullable=false)
	private String password;
	
	@Column(name="enabled")
	private Integer enabled;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private RoleDAO role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public RoleDAO getRole() {
		return role;
	}

	public void setRole(RoleDAO role) {
		this.role = role;
	}
	
	
}
