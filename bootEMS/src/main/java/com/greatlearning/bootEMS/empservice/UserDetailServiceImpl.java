package com.greatlearning.bootEMS.empservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.bootEMS.entities.User;
import com.greatlearning.bootEMS.repositries.UserRepository;
import com.greatlearning.bootEMS.security.MyUserDetails;

public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository x;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = x.getUserByUsername(username);
		
		 if (user == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }
		return new MyUserDetails(user);
	}

}
