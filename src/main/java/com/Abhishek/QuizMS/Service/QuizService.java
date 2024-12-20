package com.Abhishek.QuizMS.Service;

import com.Abhishek.QuizMS.Repository.QuestionRepository;
import com.Abhishek.QuizMS.Repository.QuizRepository;
import com.Abhishek.QuizMS.Repository.quizQuestionList;
import com.Abhishek.QuizMS.entity.ClientResponse;
import com.Abhishek.QuizMS.entity.QuestionWrapper;
import com.Abhishek.QuizMS.entity.Questions;
import com.Abhishek.QuizMS.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private quizQuestionList quizQuestionList;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Questions> list=questionRepository.findRandomQuestionByCategory(category,numQ);

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionList(list);

        quizRepository.save(quiz);
        return ResponseEntity.status(HttpStatus.CREATED).body("Success");
    }

    public ResponseEntity<List<QuestionWrapper>> getById(Long id) {
        Quiz quiz=quizRepository.findById(id).get();
        List<Questions> questions=quiz.getQuestionList();
        List<QuestionWrapper> questionWrappers=new ArrayList<>();
        for(Questions q:questions){
            QuestionWrapper qw=new QuestionWrapper(
                    q.getId()
                    ,q.getQuestions(),q.getOption1(),q.getOption2()
                    , q.getOption3(),q.getOption4());
            questionWrappers.add(qw);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(questionWrappers);
    }

    public ResponseEntity<String> calculateScore(Long id,List<ClientResponse> clientResponses) {
        int correct=0;
        Quiz quiz=quizRepository.findById(id).get();
        List<Questions> questions=quiz.getQuestionList();
        int i=0;
        for(ClientResponse CR:clientResponses){
            if(CR.getResponse().equalsIgnoreCase(questions.get(i).getAnswers())){
                correct++;
            }
            i++;
        }

        return ResponseEntity.status(HttpStatus.OK).body("your score is : "+correct);
    }
}
