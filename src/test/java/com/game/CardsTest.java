package com.game;


import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CardsTest {
    @Test
    public void should_card_1_is_Club_2() {
        Cards cards = new Cards();

        assertThat(cards.getCard(1), is(new Card("2", "Club")));
    }

    @Test
    public void should_card_0_is_different_after_reshuffle() {
        Cards cards = new Cards();

        cards.Reshuffle();

        assertThat(cards.getCard(0).equals(new Cards().getCard(0)), is(false));
    }

}
