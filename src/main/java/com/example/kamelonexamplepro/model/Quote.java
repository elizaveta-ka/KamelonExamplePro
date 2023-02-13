package com.example.kamelonexamplepro.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "quotes")
public class Quote {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "score_quote")
    private int score;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "historyScore", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Score> historyScores;

    public Quote () {
    }

    public Quote(int id, int score, User user) {
        this.id = id;
        this.score = score;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<Score> getHistoryScores() {
        return historyScores;
    }

    public void setHistoryScores(Collection<Score> historyScores) {
        this.historyScores = historyScores;
    }
}
