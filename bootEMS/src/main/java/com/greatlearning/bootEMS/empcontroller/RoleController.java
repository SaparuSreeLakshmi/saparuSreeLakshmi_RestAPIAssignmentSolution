package com.greatlearning.bootEMS.empcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.bootEMS.empservice.RoleService;
import com.greatlearning.bootEMS.entities.Role;

@Controller
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired 
	private RoleService roleService;
	
	// endpoint to add roles into system
		@PostMapping("/addRole")
		public void saveRole (String roleName) {
			Role x = new Role (roleName);
			roleService.save(x);
		}

}
