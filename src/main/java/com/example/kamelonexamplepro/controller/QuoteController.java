package com.example.kamelonexamplepro.controller;

import com.example.kamelonexamplepro.model.Quote;
import com.example.kamelonexamplepro.model.Score;
import com.example.kamelonexamplepro.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private ResponseEntity<String> saveQuote(@RequestBody Quote quote) {
        Quote quoteNew = new Quote(quote.getScore(), quote.getUser());
        quoteService.saveQuote(quoteNew);
        Score score = new Score();
        score.setDate(LocalDateTime.now());
        score.setQuote(quoteNew);
        score.setHistoryScore(quoteNew.getScore());
        scoreService.saveScore(score);
        return new ResponseEntity<> (HttpStatus.OK);
    }

    @PutMapping(value = "/quote/{id}", produces = "application/json")
    private void updateQuote(@PathVariable("id") int id,@RequestBody Quote quote) {
        Quote changeQuote = quoteService.getQuoteById(id);
        changeQuote.setScore(quote.getScore());
        quoteService.saveQuote(changeQuote);
        Score score = new Score();
        score.setDate(LocalDateTime.now());
        score.setQuote(quote);
        score.setHistoryScore(quote.getScore());
        scoreService.saveScore(score);
    }


    //delete quote
    @DeleteMapping("delete/quote/{id}")
    private void deleteQuote(@PathVariable("id") int id) {
        scoreService.deleteScoreByQuoteId(id);
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
    quoteService.saveQuote(quote);
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
        quoteService.saveQuote(quote);
    }
    //10 best quotes
    @GetMapping("/scores")
    private List<Quote> bestQuotes(){
        return quoteService.bestQuotes();
    }

}
