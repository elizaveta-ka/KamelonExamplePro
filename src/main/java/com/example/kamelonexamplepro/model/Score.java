package com.example.kamelonexamplepro.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private int id;
    @Column(name = "date_score")
    private LocalDateTime date;
    @Column(name = "history_score")
    private int historyScore;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "quote_id")
    private Quote quote;

    public Score() {

    }

    public Score(LocalDateTime date, Quote quote) {
        this.date = date;
        this.quote = quote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    public int getHistoryScore() {
        return historyScore;
    }

    public void setHistoryScore(int historyScore) {
        this.historyScore = historyScore;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", date=" + date +
                ", quote=" + quote +
                '}';
    }
}
