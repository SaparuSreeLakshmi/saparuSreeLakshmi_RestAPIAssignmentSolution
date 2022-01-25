package com.greatlearning.bootEMS.empservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.bootEMS.entities.Role;
import com.greatlearning.bootEMS.repositries.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository x;

	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		x.save(role);
		
	}

}
