package com.abc.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailPrinciple implements UserDetails{
	
	private UserEntity entity;
	
	public UserDetailPrinciple(UserEntity entity) {
		this.entity = entity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority > lis = new ArrayList<GrantedAuthority>();
		entity.getPermissions().forEach(p ->{
			GrantedAuthority authority = new SimpleGrantedAuthority(p);
			lis.add(authority);
		}
		
		);
		entity.getRoles().forEach(r ->{
			
			GrantedAuthority authority = new SimpleGrantedAuthority(r);
			lis.add(authority);
		}
		
		);
		
		return lis;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return entity.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return entity.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
