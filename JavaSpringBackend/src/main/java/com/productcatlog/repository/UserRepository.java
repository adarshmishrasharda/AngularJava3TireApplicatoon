package com.productcatlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcatlog.pojo.UserRegistration;

public interface UserRepository extends JpaRepository<UserRegistration, Long> {

	public UserRegistration findByUsername(String username);
}
