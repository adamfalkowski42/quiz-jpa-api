package com.codinghulk.javaquiz.springjpaapi.controller;

import com.codinghulk.javaquiz.springjpaapi.model.Question;
import com.codinghulk.javaquiz.springjpaapi.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class Controller {

    private final QuestionService questionService;

    @Autowired
    public Controller(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    @CrossOrigin(origins = "http://localhost:4201")
    public List<Question> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("/questions/{id}")
    @CrossOrigin(origins = "http://localhost:4201")
    public Question getQuestion(@PathVariable Long id){return questionService.getQuestion(id);};


    @PostMapping("/question")
    @CrossOrigin(origins = "http://localhost:4201")
    public @ResponseBody
    ResponseEntity<Question> addQuestion(@RequestBody Question question){
        Question returnQuestion = questionService.addNewQuestion(question);
        return new ResponseEntity<>(returnQuestion, HttpStatus.OK);

    }

    @PostMapping("/questionsAll")
    @CrossOrigin(origins = "http://localhost:4201")
    public void addAllQuestions(@RequestBody List<Question> questionList){
        questionService.addQuestions(questionList);
    }

    @PutMapping("/question")
    @CrossOrigin(origins = "http://localhost:4201")
    public void updateQuestion(@RequestBody Question question){
        questionService.updateQuestion(question);
    }

    @DeleteMapping("/question/{id}")
    @CrossOrigin(origins = "http://localhost:4201")
    public void deleteQuestion(@PathVariable Long id){
        questionService.deleteQuestion(id);
    }





}
