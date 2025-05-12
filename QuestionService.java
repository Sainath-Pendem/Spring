package com.example.quiz.Service;


import com.example.quiz.Dao.QuestionDao;
import com.example.quiz.Model.Question;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questiondao;

    public List<Question> getallquestions() {
        return questiondao.findAll();
    }

    public List<Question> getquestionbylang(String lang) {
        return questiondao.findByLang(lang);
    }

    public String addquestion(Question question) {
        questiondao.save(question);
        return "hi";
    }

    public String deletequestion(Integer id) {
        questiondao.deleteById(id);
        return "success";
    }
}
