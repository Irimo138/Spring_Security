package com.example.demo.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.Data;

@Data
@Entity
@Embeddable
@Table(name="users")
public class User{
	
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String password;
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@Column(nullable=true)
	private List<Authority> authorities;
	
	@Nullable
	private String role;
	
	public User() {}
	
	public User(String username, String password, Authority auth, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
}
