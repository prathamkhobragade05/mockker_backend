package com.softara.mockker.repository;

import java.util.*; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softara.mockker.model.TestResultModel;


@Repository
public interface TestResultRepository extends JpaRepository<TestResultModel, Long>{
	List<TestResultModel> findByUserId(Long userId);
}
