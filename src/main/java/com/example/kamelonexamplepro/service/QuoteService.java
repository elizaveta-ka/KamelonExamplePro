package com.example.kamelonexamplepro.service;

import com.example.kamelonexamplepro.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.kamelonexamplepro.repository.QuoteRepository;

import java.util.*;

@Service
public class QuoteService {

    private QuoteRepository quoteRepository;

    @Autowired
    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public List<Quote> getAllQuotes() {
        List<Quote> quotes = new ArrayList<>();
        quoteRepository.findAll().forEach(quote -> quotes.add(quote));
        return quotes;
    }

    public Quote getQuoteById(int id){
        return quoteRepository.findById(id).get();
    }

    public void saveOrUpdate(Quote quote){
        quoteRepository.save(quote);
    }

    public void deleteQuote(int id) {
        quoteRepository.deleteById(id);
    }

    //voting on quotes
    public int increaseScore(int score){
        return score += 1;
    }

    public int downgradeScore(int score) {
        return score -= 1;
    }

    public List<Quote> bestQuotes () {
        List<Quote> quoteList = new ArrayList<>();
        quoteRepository.findAll().forEach(quote -> quoteList.add(quote));
        List<Quote> bestQuotes = new ArrayList<>();

        Collections.sort(quoteList, new Comparator<Quote>() {
            @Override
            public int compare(Quote o1, Quote o2) {
                return o2.getScore() - o1.getScore();
            }
        });
        for (int i = 0; i < 10; i++) {
            bestQuotes.add(quoteList.get(i));
        }
        return bestQuotes;
    }
}
