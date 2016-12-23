package com.conference.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conference.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByEmail(String email);
}
