package com.game;

import java.util.ArrayList;
import java.util.List;

public class Action {
    private Scorer scorer;
    private List<String> cards;

    public Action() {
        scorer = new Scorer();
        cards = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Action)) return false;

        Action action = (Action) o;

        if (!cards.equals(action.cards)) return false;
        if (!scorer.equals(action.scorer)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = scorer.hashCode();
        result = 31 * result + cards.hashCode();
        return result;
    }

    public Integer getScore() {
        return scorer.getScore();
    }

    public void hit(Card card) {
        scorer.getCard(card);
        cards.add(card.getCardPath());
    }

    public List<String> getCards() {
        return cards;
    }

    public void backCard(int cardIndex) {
        cards.set(cardIndex, System.getProperty("user.dir") + "/images/images/stick_small.jpg");
    }
}
