package com.example.quiz.Service;

import com.example.quiz.Dao.QuestionDao;
import com.example.quiz.Dao.QuizDao;
import com.example.quiz.Model.Question;
import com.example.quiz.Model.QuestionWrapper;
import com.example.quiz.Model.Quiz;
import com.example.quiz.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizdao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createquiz(String category, String title, int numQ) {

        List<Question> questions=questionDao.findRandomQuestions(category,numQ);

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizdao.save(quiz);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getquiz(Integer id) {
        Optional<Quiz> quiz=quizdao.findById(id);
        List<Question> questionsfromdb=quiz.get().getQuestions();
        List<QuestionWrapper> questionfromuser=new ArrayList<>();
        for(Question q:questionsfromdb){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getC1(),q.getC2(),q.getC3(),q.getC4(),q.getQuestion());
            questionfromuser.add(qw);
        }
        return new ResponseEntity<>(questionfromuser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calquiz(Integer id, List<Response> response) {
        Optional<Quiz> quiz=quizdao.findById(id);
        List<Question> questions= quiz.get().getQuestions();
        int crct=0;
        int i=0;
        for(Response r:response){
            if(r.getAns().equals(questions.get(i).getAns())){
                crct++;
            }
            i++;
        }
        return new ResponseEntity<>(crct,HttpStatus.OK);

    }
}
