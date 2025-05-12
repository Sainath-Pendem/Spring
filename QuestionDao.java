package com.example.quiz.Dao;

import com.example.quiz.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer>{

    List<Question> findByLang( String lang);

    @Query(value = "select * from Question q Where q.lang=:lang ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestions(String lang, int numQ);

}
