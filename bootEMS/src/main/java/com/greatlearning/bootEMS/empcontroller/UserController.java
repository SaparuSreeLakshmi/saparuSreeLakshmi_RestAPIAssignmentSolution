package com.greatlearning.bootEMS.empcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.bootEMS.empservice.UserService;
import com.greatlearning.bootEMS.entities.Role;
import com.greatlearning.bootEMS.entities.User;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// endpoint to add number of users mentioning its role, username and password
		@PostMapping("/addUser")
		public void saveUser(String username, String password, List<Role> roles) {
			User y = new User (username, password, roles);
			userService.save(y);
		}

}
