package com.game;


import org.junit.Test;

import java.util.Random;

import static java.lang.Math.abs;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CardsTest {
    @Test
    public void should_card_1_is_Club_2() {
        Cards cards = new Cards();
        assertThat(cards.getCard(1), is(new Card("2", "Club")));
    }

    @Test
    public void should_card_20_is_Spade_8() {
        Cards cards = new Cards();
        Random random = mock(Random.class);
        when(random.nextInt(Cards.TOTAL)).thenReturn(abs(Cards.TOTAL / 2));

        cards.oneReshuffle(random);
        assertThat(cards.getCard(20), is(new Card("8", "Spade")));
    }

}
