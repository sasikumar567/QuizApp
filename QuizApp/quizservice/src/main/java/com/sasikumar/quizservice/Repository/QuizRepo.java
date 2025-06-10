package com.sasikumar.quizservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sasikumar.quizservice.Model.Quiz;


@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {

}
