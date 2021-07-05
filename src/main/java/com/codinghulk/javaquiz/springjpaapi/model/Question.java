package com.codinghulk.javaquiz.springjpaapi.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Question {

    @Id
    @SequenceGenerator(name="question_sequence", sequenceName="question_sequence",allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String question;
    private String answer;
    private boolean answered;
    private LocalDate dateTimeStamp;

    public Question() {}

    public Question(Long id, String question, String answer, boolean answered, LocalDate dateTimeStamp) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.answered = answered;
        this.dateTimeStamp = dateTimeStamp;
    }

    public Question(String question, String answer, boolean answered, LocalDate dateTimeStamp) {
        this.question = question;
        this.answer = answer;
        this.answered = answered;
        this.dateTimeStamp = dateTimeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {

        this.answer = answer;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public LocalDate getDateTimeStamp() {
        return dateTimeStamp;
    }

    public void setDateTimeStamp(LocalDate dateTimeStamp) {
        if(dateTimeStamp == null){
            dateTimeStamp = LocalDate.now();
        }
        this.dateTimeStamp = dateTimeStamp;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", answered=" + answered +
                ", dateTimeStamp=" + dateTimeStamp +
                '}';
    }
}
