package com.Abhishek.QuizMS.Repository;

import com.Abhishek.QuizMS.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface quizQuestionList extends JpaRepository<Quiz,Long> {
}
