package com.game;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class CardTest {
    @Test
    public void should_get_card_A() {
        Card card = new Card("A", "Heart");

        assertThat(card.getMark(), is("A"));
    }

    @Test
    public void should_not_get_card_1() {
        Card card = new Card("1", "Club");

        assertThat(card.getMark(), is("1"));
    }

    @Test
    public void should_card_A_point_1() {
        Card card = new Card("A", "Diamond");

        assertThat(card.getPoint(), is(1));
    }

    @Test
    public void should_card_5_point_5() {
        Card card = new Card("5", "Spade");

        assertThat(card.getPoint(), is(5));
    }

    @Test
    public void should_get_Spade() {
        Card card = new Card("5", "Spade");
        assertThat(card.getSuit(), is("Spade"));
    }

    @Test
    public void should_get_Spade_5() {
        Card card = new Card("5", "Spade");
        assertThat(card.getCard(), is(new Card("5", "Spade")));
    }

    @Test
    public void should_get_correct_card_path() {
        Card card = new Card("4","Club");
        assertThat(card.getCardPath(), is("images/images/cards/Clubs/4.jpg"));
    }
}
