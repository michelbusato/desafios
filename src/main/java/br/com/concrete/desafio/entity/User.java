package br.com.concrete.desafio.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.concrete.desafio.util.DataSerializerJSON;

@Entity
public class User {
	@Id
	@Column
	private String id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;	
	@Column(length = 600)
	private String token;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE })
	private List<Phone> phones;
	@Column
	@JsonSerialize(using = DataSerializerJSON.class)
	private Date created;
	@Column
	@JsonSerialize(using = DataSerializerJSON.class)
	private Date modified;
	@Column
	@JsonSerialize(using = DataSerializerJSON.class)
	private Date last_login;

	public User() {
	}

	public User(String id, String name, String email, String password, List<Phone> phones, Date created, Date modified,
			Date last_login, String token) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
		this.created = created;
		this.modified = modified;
		this.last_login = last_login;
		this.token = token;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
