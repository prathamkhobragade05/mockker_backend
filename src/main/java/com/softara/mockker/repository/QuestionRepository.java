package com.softara.mockker.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.softara.mockker.model.QuestionModel;


@EnableJpaRepositories
@Repository
public interface QuestionRepository extends JpaRepository<QuestionModel,Long>{
	List<QuestionModel> findByTestId(Long testId);
	List<QuestionModel> findByTestIdOrderByQuestionIdAsc(Long testId);
}
