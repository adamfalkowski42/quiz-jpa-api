package com.codinghulk.javaquiz.springjpaapi.respository;

import com.codinghulk.javaquiz.springjpaapi.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
