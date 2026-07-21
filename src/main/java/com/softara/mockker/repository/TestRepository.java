package com.softara.mockker.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.softara.mockker.model.TestModel;


@EnableJpaRepositories
@Repository
public interface TestRepository extends JpaRepository<TestModel,Long>{

}
