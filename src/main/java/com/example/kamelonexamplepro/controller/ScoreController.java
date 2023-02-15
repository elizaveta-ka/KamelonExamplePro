package com.example.kamelonexamplepro.controller;

import com.example.kamelonexamplepro.model.Score;
import com.example.kamelonexamplepro.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ScoreController {

    private ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("/score")
    private List<Score> getAllScore() {
        return scoreService.getAllScores();
    }

    @GetMapping("/history/quote/{id}")
    private List<Score> historyScore(@PathVariable("id") int id) {

        return scoreService.getHistory(id);
    }
}
