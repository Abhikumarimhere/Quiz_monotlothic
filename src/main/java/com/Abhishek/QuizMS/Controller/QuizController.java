package com.Abhishek.QuizMS.Controller;

import com.Abhishek.QuizMS.Service.QuizService;
import com.Abhishek.QuizMS.entity.ClientResponse;
import com.Abhishek.QuizMS.entity.QuestionWrapper;
import com.Abhishek.QuizMS.entity.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> CreateQuiz(@RequestParam("category") String category,@RequestParam("numQ") int numQ,
                                             @RequestParam("title") String title ){
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable("id") Long id){
        return quizService.getById(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<String> calculateScore(@PathVariable("id")Long id,@RequestBody List<ClientResponse> clientResponses){
        return quizService.calculateScore(id,clientResponses);
    }
}
