package com.QuizApp.question_service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.QuizApp.question_service.Model.Question;



@Repository
public interface QuestionRepo  extends JpaRepository<Question, Integer>{

	List<Question> findByCategory(String category);
	@Query(value="select q.id from question q where q.category=:category order by rand() limit :num",nativeQuery = true)
	List<Integer> findByCategoryRandom(String category, int num);

}
