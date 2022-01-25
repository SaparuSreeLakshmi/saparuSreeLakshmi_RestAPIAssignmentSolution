package com.greatlearning.bootEMS.empservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.bootEMS.entities.User;
import com.greatlearning.bootEMS.repositries.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository x;

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		x.save(user);
	}

}
