package com.sasikumar.quizservice.Repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import com.sasikumar.quizservice.Model.QuestionWrapper;
import com.sasikumar.quizservice.Model.Response;



@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionRepo {
	@GetMapping("questions/create")
	public ResponseEntity<List<Integer>> createQuiz(@RequestParam String cat,@RequestParam int noQ);
	
	@PostMapping("questions/getquestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestions(@RequestBody List<Integer> Qid);
	
	@PostMapping("questions/getscore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> res);

}
