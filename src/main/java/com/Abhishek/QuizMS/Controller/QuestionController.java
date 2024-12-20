package com.Abhishek.QuizMS.Controller;

import com.Abhishek.QuizMS.Service.QuestionService;
import com.Abhishek.QuizMS.entity.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/allQuestion")
    public String Question(){
        return "Here are your question";
    }
    @PostMapping("/Save")
    public ResponseEntity<Questions> SaveQuestions(@RequestBody Questions questions){
        questionService.saveQuestions(questions);
        return ResponseEntity.status(HttpStatus.OK).body(questions);
    }

    @GetMapping("/AllQuestions")
    public List<Questions> getallQuestion(){
        List<Questions>ans=questionService.getAllQuestions();
        return ans;
    }

    @GetMapping("/category/{Category}")
    public List<Questions> getByCategory(@PathVariable("Category") String Category){
        List<Questions> ans=questionService.getByCategory(Category);
        return ans;
    }
}
