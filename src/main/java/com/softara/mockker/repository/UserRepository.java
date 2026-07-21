package com.softara.mockker.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.softara.mockker.model.UserModel;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {

	boolean existsByEmail(String email);

	UserModel findByEmail(String email);

}
