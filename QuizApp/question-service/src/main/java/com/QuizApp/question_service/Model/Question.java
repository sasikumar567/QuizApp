package com.QuizApp.question_service.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class Question {
@Id
@GeneratedValue(strategy =  GenerationType.IDENTITY)
private int id;
private String question;
private String option1;
private String option2;
private String option3;
private String option4;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public String getOption1() {
	return option1;
}
public void setOption1(String option1) {
	this.option1 = option1;
}
public String getOption2() {
	return option2;
}
public void setOption2(String option2) {
	this.option2 = option2;
}
public String getOption3() {
	return option3;
}
public void setOption3(String option3) {
	this.option3 = option3;
}
public String getOption4() {
	return option4;
}
public void setOption4(String option4) {
	this.option4 = option4;
}
public String getCorrectOption() {
	return correctOption;
}
public void setCorrectOption(String correctOption) {
	this.correctOption = correctOption;
}
public String getDifficulty() {
	return difficulty;
}
public void setDifficulty(String difficulty) {
	this.difficulty = difficulty;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
private String correctOption;
private String difficulty;
private String category;
}
