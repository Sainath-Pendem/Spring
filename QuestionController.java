package com.example.quiz.Controller;


import com.example.quiz.Model.Question;
import com.example.quiz.Service.QuestionService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allquestions")
    public List<Question> getallquestions(){
        return questionService.getallquestions();
    }

    @GetMapping("/category/{lang}")
    public List<Question> getquestionbylang(@PathVariable String lang){
        return questionService.getquestionbylang(lang);
    }

    @PostMapping("/add")
    public String addquestion(@RequestBody Question question){
        return questionService.addquestion(question);
    }


    @DeleteMapping("/delete/{Id}")
    public String deletequestion(@PathVariable Integer Id){
        return questionService.deletequestion(Id);
    }
}
