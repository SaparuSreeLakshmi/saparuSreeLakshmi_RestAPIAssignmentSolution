package com.greatlearning.bootEMS.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.bootEMS.entities.Role;

public interface RoleRepository extends JpaRepository <Role, Integer> {

}
