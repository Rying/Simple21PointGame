package com.game;

public class Card {
    private String suit;
    private String mark;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;

        Card card = (Card) o;

        if (mark != null ? !mark.equals(card.mark) : card.mark != null) return false;
        if (suit != null ? !suit.equals(card.suit) : card.suit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = suit != null ? suit.hashCode() : 0;
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        return result;
    }

    public Card(String mark, String suit) {
        this.mark = mark;
        this.suit = suit;
    }

    public String getMark() {
        return mark;
    }

    public Integer getPoint() {
        return "A".indexOf(mark) != -1 ? 1 : ("JQK".indexOf(mark) != -1 ? 10 : Integer.parseInt(mark));
    }

    public String getSuit() {
        return suit;
    }

    public Card getCard() {
        return this;
    }

    public String getCardPath() {
        return  "/images/cards/" + suit + "s/" + mark + ".jpg";
    }
}
