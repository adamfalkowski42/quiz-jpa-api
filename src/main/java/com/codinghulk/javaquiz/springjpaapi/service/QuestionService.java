package com.codinghulk.javaquiz.springjpaapi.service;

import com.codinghulk.javaquiz.springjpaapi.model.Question;
import com.codinghulk.javaquiz.springjpaapi.respository.QuestionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    public Question addNewQuestion(Question question) {
        if (question.getDateTimeStamp() == null) {
            question.setDateTimeStamp(LocalDate.now());
        }
       return questionRepository.save(question);
    }

    public void addQuestions(List<Question> questions) {
        questionRepository.saveAllAndFlush(questions);
    }

    @Transactional
    public void updateQuestion(Question question) {
        Question updateQuestion = questionRepository.findById(question.getId()).orElseThrow(
                () -> new IllegalStateException("Question with this ID does not exist: " + question.getId())
        );

        if (question.getQuestion() != null && question.getQuestion().length() > 0 && !Objects.equals(updateQuestion.getQuestion(), question.getQuestion())) {
            updateQuestion.setQuestion(question.getQuestion());
        }

        if (question.getAnswer() != null && question.getAnswer().length() > 0 && !Objects.equals(updateQuestion.getAnswer(), question.getAnswer())) {
            updateQuestion.setAnswer(question.getAnswer());
        }
        if (!Objects.equals(updateQuestion.isAnswered(), question.isAnswered())) {
            updateQuestion.setAnswered(question.isAnswered());
        }
    }


    public void deleteQuestion(Long id) {
        Question deleteQuestion = questionRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Question with this ID does not exist: " + id)
        );

        questionRepository.delete(deleteQuestion);
    }


    public Question getQuestion(Long id) {
        return questionRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Question with this ID does not exist: " + id)
        );

    }

    public void resetQuestions(List<Question> questions) {
        questionRepository.saveAll(questions);
    }
}
