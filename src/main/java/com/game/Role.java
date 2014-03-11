package com.game;


import java.util.List;

public enum Role {
    PLAYER(new Action()), HOST(new Action());

    private Action action;

    Role(Action action) {
        this.action = action;
    }

    public void hit(Card card) {
        action.hit(card);
    }

    public int getScore() {
        return action.getScore();
    }


    public List<String> getCards() {
        return action.getCards();
    }

    public void backCard(int cardIndex) {
        action.backCard(cardIndex);
    }

    public void clean() {
        action = new Action();
    }
}
