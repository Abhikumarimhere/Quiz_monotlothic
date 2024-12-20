package com.Abhishek.QuizMS.Service;

import com.Abhishek.QuizMS.entity.Questions;

import java.util.List;

public interface QuestionService {
    List<Questions> getAllQuestions();

    void saveQuestions(Questions questions);

    List<Questions> getByCategory(String Category);
}
