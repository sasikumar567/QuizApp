package com.QuizApp.question_service.Controller;

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

import com.QuizApp.question_service.Model.Question;
import com.QuizApp.question_service.Model.QuestionWrapper;
import com.QuizApp.question_service.Model.Response;
import com.QuizApp.question_service.Service.QuestionService;



@RestController
@RequestMapping("questions")
public class QuestionController {
	
	@Autowired
	QuestionService questionservice;
	
	@GetMapping("allquestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionservice.getAllquestions();
	}
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestuionByCategory(@PathVariable String category){
		return questionservice.getByCategory(category);
	}
	@PostMapping("/addquestions")
	public ResponseEntity<List<Question>> addQuestions(@RequestBody List<Question> questions) {
		return questionservice.saveAll(questions);
		
	}
	
	@GetMapping("create")
	public ResponseEntity<List<Integer>> createQuiz(@RequestParam String cat,@RequestParam int noQ){
		return questionservice.create(cat,noQ);
	}
	@PostMapping("getquestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestions(@RequestBody List<Integer> Qid){
		return questionservice.getQuestions(Qid);
	}
	
	@PostMapping("getscore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> res){
		return questionservice.calculateScore(res);
	}
}
