package com.example.quiz.Controller;


import com.example.quiz.Model.Question;
import com.example.quiz.Model.QuestionWrapper;
import com.example.quiz.Model.Response;
import com.example.quiz.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createquiz(@RequestParam String category,@RequestParam String title,@RequestParam int numQ){
        return quizService.createquiz(category,title,numQ);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getquiz(@PathVariable Integer id){
        return quizService.getquiz(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> calquiz(@PathVariable Integer id,@RequestBody List<Response> response){
        return quizService.calquiz(id,response);
    }
}
