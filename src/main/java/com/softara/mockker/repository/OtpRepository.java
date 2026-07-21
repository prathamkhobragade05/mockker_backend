package com.softara.mockker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softara.mockker.model.OtpModel;

public interface OtpRepository extends JpaRepository<OtpModel,Long> {
	
	Optional<OtpModel> findTopByEmailOrderByExpiryTimeDesc(String email);

}
