package com.greatlearning.bootEMS.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.bootEMS.entities.User;

public interface UserRepository extends JpaRepository <User, Long> {
	public User getUserByUsername(String username);

}
