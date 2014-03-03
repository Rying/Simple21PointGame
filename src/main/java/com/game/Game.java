package com.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Scorer playerScorer;
    private Scorer hostScorer;
    private List<String> playerCards;
    private List<String> hostCards;
    private Role role;
    private int cardsIndex;
    private Cards cards;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;

        Game game = (Game) o;

        if (cardsIndex != game.cardsIndex) return false;
        if (!hostCards.equals(game.hostCards)) return false;
        if (!hostScorer.equals(game.hostScorer)) return false;
        if (!playerCards.equals(game.playerCards)) return false;
        if (!playerScorer.equals(game.playerScorer)) return false;
        if (role != game.role) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = playerScorer.hashCode();
        result = 31 * result + hostScorer.hashCode();
        result = 31 * result + playerCards.hashCode();
        result = 31 * result + hostCards.hashCode();
        result = 31 * result + role.hashCode();
        result = 31 * result + cardsIndex;
        return result;
    }

    public Game() {
        playerScorer = new Scorer();
        hostScorer = new Scorer();
        playerCards = new ArrayList<String>();
        hostCards = new ArrayList<String>();
        setRole(Role.PLAYER);
        cards = new Cards();
        cardsIndex = 0;
    }

    public int getPlayerScore() {
        return playerScorer.getScore();
    }

    public int getHostScore() {
        return hostScorer.getScore();
    }

    public void start() {
        playerCards.clear();
        hostCards.clear();
        playerScorer.setScore(0);
        hostScorer.setScore(0);
        cardsIndex = 0;
        reshuffle();
        for (int i = 0; i < 2; i++) {
            playerAddOneCardScore(cards.getCard(cardsIndex++));
            hostAddOneCardScore(cards.getCard(cardsIndex++));
            playerCards.add("images/images/stick_small.jpg");
            hostCards.add("images/images/stick_small.jpg");
        }

        setRole(Role.PLAYER);
    }

    public void reshuffle() {
        cards.Reshuffle();
    }

    public void addOneCardPathToPlayerCards(Card card) {
        playerCards.add(card.getCardPath());
    }


    public List<String> getPlayerCards() {
        return playerCards;
    }

    public void playerAddOneCardScore(Card card) {
        playerScorer.getCard(card);
    }

    public void hostAddOneCardScore(Card card) {
        hostScorer.getCard(card);
    }

    public void addOneCardPathToHostCards(Card card) {
        hostCards.add(card.getCardPath());
    }

    public List<String> getHostCards() {
        return hostCards;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void hit() {
        switch (role) {
            case PLAYER:
                playerHit(cards.getCard(cardsIndex++));
                break;
            case HOST:
                hostHit(cards.getCard(cardsIndex++));
                break;
            default:
                break;
        }
    }

    public void playerHit(Card card) {
        playerAddOneCardScore(card);
        addOneCardPathToPlayerCards(card);
    }

    public void hostHit(Card card) {
        hostAddOneCardScore(card);
        addOneCardPathToHostCards(card);
    }

    public void stay() {
        setRole(Role.HOST);
    }
}
