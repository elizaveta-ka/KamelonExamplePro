package com.example.kamelonexamplepro.controller;

import com.example.kamelonexamplepro.model.Quote;
import com.example.kamelonexamplepro.model.Score;
import com.example.kamelonexamplepro.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.kamelonexamplepro.service.QuoteService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class QuoteController {

    private QuoteService quoteService;

    private ScoreService scoreService;

    @Autowired
    public QuoteController(QuoteService quoteService, ScoreService scoreService) {
        this.quoteService = quoteService;
        this.scoreService = scoreService;
    }
    //get all quotes
    @GetMapping("/quote")
    private List<Quote> getAllQuotes() {
        return quoteService.getAllQuotes();
    }
    //get quote
    @GetMapping("/quote/{id}")
    private Quote getQuote(@PathVariable("id") int id) {
       return quoteService.getQuoteById(id);
    }
    //save and update quote
    @PostMapping(value = "/quote", produces = "application/json")
    private int saveQuote(@RequestBody Quote quote) {
        Score score = new Score();
        score.setDate(LocalDateTime.now());
        score.setQuote(quote);
        score.setHistoryScore(quote.getScore());
        quoteService.saveOrUpdate(quote);
        scoreService.saveScore(score);
        return quote.getId();
    }

    //delete quote
    @DeleteMapping("/quote/{id}")
    private void deleteQuote(@PathVariable("id") int id) {
        quoteService.deleteQuote(id);
    }

    @PostMapping("/down/quote/{id}")
    private void downScore(@PathVariable("id") int id) {
    Quote quote = quoteService.getQuoteById(id);
    quote.setScore(quoteService.downgradeScore(quote.getScore()));
        Score score = new Score();
        score.setDate(LocalDateTime.now());
        score.setQuote(quote);
        score.setHistoryScore(quote.getScore());
        scoreService.saveScore(score);
    quoteService.saveOrUpdate(quote);
    }

    @PostMapping("/up/quote/{id}")
    private void upScore(@PathVariable("id") int id) {
        Quote quote = quoteService.getQuoteById(id);
        quote.setScore(quoteService.increaseScore(quote.getScore()));
        Score score = new Score();
        score.setDate(LocalDateTime.now());
        score.setQuote(quote);
        score.setHistoryScore(quote.getScore());
        scoreService.saveScore(score);
        quoteService.saveOrUpdate(quote);
    }
    //10 best quotes
    @GetMapping("/scores")
    private List<Quote> bestQuotes(){
        return quoteService.bestQuotes();
    }

}
