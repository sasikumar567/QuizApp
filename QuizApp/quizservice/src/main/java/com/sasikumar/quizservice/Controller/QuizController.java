package com.sasikumar.quizservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sasikumar.quizservice.Model.QuestionWrapper;
import com.sasikumar.quizservice.Model.Response;
import com.sasikumar.quizservice.Service.QuizService;



@RestController
@RequestMapping("quiz")
public class QuizController {
	@Autowired
	QuizService quizservice;
	@GetMapping("questions")
	public String getQuestions(@RequestParam String title,@RequestParam String cat,@RequestParam int noq ) {
		quizservice.CreateQuiz(title, cat, noq);
		return "Success";
	}
	
	@GetMapping("getquiz/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id) {
		 return quizservice.getQuiz(id);
	}
	
	@PostMapping("{id}/submit")
	public ResponseEntity<Integer>  evaluate(@PathVariable int id,@RequestBody List<Response> response){
		return quizservice.calculate(id,response);
	}
}
