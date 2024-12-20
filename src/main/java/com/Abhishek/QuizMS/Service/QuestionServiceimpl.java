package com.Abhishek.QuizMS.Service;

import com.Abhishek.QuizMS.Repository.QuestionRepository;
import com.Abhishek.QuizMS.entity.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceimpl implements QuestionService{
    @Autowired
    private QuestionRepository questionRepository;

    public List<Questions> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public void saveQuestions(Questions questions) {
        questionRepository.save(questions);
    }



    @Override
    public List<Questions> getByCategory(String Category) {
        return questionRepository.findByCategory(Category);
    }
}
