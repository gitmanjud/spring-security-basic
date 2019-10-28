package com.abc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.abc.dao.UserRepository;
import com.abc.entity.UserDetailPrinciple;
import com.abc.entity.UserEntity;

//@Service
public class UserDetailsServices implements UserDetailsService {

	
	public UserDetailsServices(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUserName(username);
		
		UserDetailPrinciple userDetailPrinciple  = new UserDetailPrinciple(user);
		userDetailPrinciple.getPassword();
		userDetailPrinciple.getAuthorities();
		return userDetailPrinciple;
	}

}
