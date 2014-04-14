package com.game;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ActionTest {
    @Test
    public void should_hit_card_5_club_get_5_score() {
        Action action = new Action();

        action.hit(new Card("5", "Club"));

        assertThat(action.getScore(), is(5));
    }

    @Test
    public void should_hit_card_5_club_get_card_path() {
        Action action = new Action();
        Card card = new Card("5", "Club");

        action.hit(card);

        assertThat(action.getCards().get(0), is(card.getCardPath()));
    }

    @Test
    public void should_back_card_get_back_img_path() {
        Action action = new Action();

        action.hit(new Card("5", "Club"));
        action.backCard(0);

        assertThat(action.getCards().get(0), is("/images/stick_small.jpg"));
    }
}
