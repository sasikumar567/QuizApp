package com.QuizApp.question_service.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.QuizApp.question_service.Model.Question;
import com.QuizApp.question_service.Model.QuestionWrapper;
import com.QuizApp.question_service.Model.Response;
import com.QuizApp.question_service.Repository.QuestionRepo;



@Service
public class QuestionService {
	@Autowired
	QuestionRepo repo;
	public ResponseEntity<List<Question>> saveAll(List<Question> questions) {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity<>( repo.saveAll(questions),HttpStatus.CREATED);}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}
	public ResponseEntity<List<Question>> getAllquestions() {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(repo.findAll(),HttpStatus.FOUND);
	}
	public ResponseEntity<List<Question>> getByCategory(String category) {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(repo.findByCategory(category),HttpStatus.FOUND);
	}
	public ResponseEntity<List<Integer>> create(String cat, int noQ) {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(repo.findByCategoryRandom(cat, noQ),HttpStatus.CREATED);
	}
	public ResponseEntity<List<QuestionWrapper>> getQuestions(List<Integer> qid) {
		List<QuestionWrapper> qw=new ArrayList<>();
		for(int i:qid) {
			Question q=(repo.findById(i).get());
			qw.add(new QuestionWrapper(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4()));
		}
		return new ResponseEntity<>(qw,HttpStatus.FOUND);
		
		
	}
	public ResponseEntity<Integer> calculateScore(List<Response> res) {
		int mark=0;
		for(Response r:res) {
			Question q=repo.findById(r.getId()).get();
			if(q.getCorrectOption().equals(r.getAnswer())) {mark++;}
			
		}
		// TODO Auto-generated method stub
		return new ResponseEntity<>(mark,HttpStatus.OK);
	}

}
