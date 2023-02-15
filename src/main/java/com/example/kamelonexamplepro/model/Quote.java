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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false, unique = true)
    private int id;
    @Column(name = "score_quote")
    private int score;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToMany (mappedBy="quote", fetch=FetchType.LAZY)
//    private Collection<Score> scores;

    public Quote () {
    }

    public Quote(int score, User user) {
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

//    public Collection<Score> getScores() {
//        return scores;
//    }
//
//    public void setScores(Collection<Score> scores) {
//        this.scores = scores;
//    }
}
