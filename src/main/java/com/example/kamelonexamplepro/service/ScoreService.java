package com.example.kamelonexamplepro.service;

import com.example.kamelonexamplepro.model.Score;
import com.example.kamelonexamplepro.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreService {

    private ScoreRepository scoreRepository;


    @Autowired
    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public void saveScore(Score score) {
        scoreRepository.save(score);
    }

    public void deleteScoreByQuoteId(int id) {
        List<Score> scores = scoreRepository.findAll();
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i).getQuote().getId() == id) {
                scoreRepository.delete(scores.get(i));
            }
        }
    }

    public List<Score> getAllScores() {
        List<Score> scores = new ArrayList<>();
        scoreRepository.findAll().forEach(score -> scores.add(score));
        return scores;
    }

    public List<Score> getHistory(int id) {
        List<Score> scores = scoreRepository.findAll();
        List<Score> scoreList = new ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i).getQuote().getId() == id) {
                scoreList.add(scores.get(i));
            }
        }
        return scoreList;
    }
}
