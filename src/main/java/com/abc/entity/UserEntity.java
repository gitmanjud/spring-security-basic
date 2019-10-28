package com.abc.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class UserEntity {

	@Id
	private String id;
	private String resource = "USER";
	private String userName;
	private String password;
	private String role;
	private String permission;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoles(){
		if(role!= null) {
			return Arrays.asList(role);
		}
		return new ArrayList<String>();
	}
	
	public List<String> getPermissions(){
		if(permission!= null) {
			return Arrays.asList(permission);
		}
		return new ArrayList<String>();
	}
	
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", resource=" + resource + ", username=" + userName + ", password=" + password
				+ ", role=" + role + ", permission=" + permission + "]";
	}

}
