package com.game;

public class Scorer {

    private int score;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scorer)) return false;

        Scorer scorer = (Scorer) o;

        if (score != scorer.score) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Scorer(int score) {
        this.score = score;
    }

    public Scorer() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void getCard(Card card) {
        score += card.getPoint();
    }
}
