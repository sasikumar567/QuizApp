package com.sasikumar.quizservice.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sasikumar.quizservice.Model.QuestionWrapper;
import com.sasikumar.quizservice.Model.Quiz;
import com.sasikumar.quizservice.Model.Response;
import com.sasikumar.quizservice.Repository.QuestionRepo;
import com.sasikumar.quizservice.Repository.QuizRepo;


@Service
public class QuizService {
@Autowired
QuizRepo quizrepo;
@Autowired
QuestionRepo questionrepo;

public String CreateQuiz(String title,String category,int num) {
	Quiz quiz=new Quiz();
	quiz.setTitle(title);
	List<Integer> questions=questionrepo.createQuiz(category, num).getBody();
	quiz.setQuestionid(questions);
	
	quizrepo.save(quiz);
	return "Success";
}

public ResponseEntity<List<QuestionWrapper>> getQuiz(int id) {
	// TODO Auto-generated method stub
	
	Quiz quiz=quizrepo.findById(id).get();
	List<Integer> q=quiz.getQuestionid();
	ResponseEntity<List<QuestionWrapper>>ans= questionrepo.getQuestions(q);
	return ans;
	
	
}

public ResponseEntity<Integer> calculate(int id, List<Response> responses) {
	// TODO Auto-generated method stub
	int ans;
	ans=questionrepo.getScore(responses).getBody();
	return new ResponseEntity<>(ans,HttpStatus.OK);
}
}
