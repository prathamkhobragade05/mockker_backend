package com.softara.mockker.repository;


import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.softara.mockker.model.ActivitiesModel;



@EnableJpaRepositories
@Repository
public interface ActivitiesRepository extends JpaRepository<ActivitiesModel,Long>{
//	List<ActivitiesModel> findAllOrderByActivityIdDesc();
}
 