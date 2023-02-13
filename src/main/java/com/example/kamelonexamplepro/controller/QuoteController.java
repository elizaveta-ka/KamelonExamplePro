package com.example.kamelonexamplepro.controller;

import com.example.kamelonexamplepro.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.kamelonexamplepro.service.QuoteService;

import java.util.List;

@RestController
public class QuoteController {

    private QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
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
    @PostMapping("/quote")
    private int saveQuote(@RequestBody Quote quote) {
        quoteService.saveOrUpdate(quote);
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
    quoteService.saveOrUpdate(quote);
    }

    @PostMapping("/up/quote/{id}")
    private void upScore(@PathVariable("id") int id) {
        Quote quote = quoteService.getQuoteById(id);
        quote.setScore(quoteService.increaseScore(quote.getScore()));
        quoteService.saveOrUpdate(quote);
    }
    //10 best quotes
    @GetMapping("/scores")
    private List<Quote> bestQuotes(){
        return quoteService.bestQuotes();
    }
}
