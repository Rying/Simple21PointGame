package com.game;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ScorerTest {
    @Test
    public void should_init_scorer_is_0() {
        Scorer scorer = new Scorer();

        assertThat(scorer.getScore(), is(0));
    }

    @Test
    public void should_get_card_4_player_score_add_4() {
        Scorer scorer = new Scorer(5);

        scorer.getCard(new Card("4", "Spade"));
        assertThat(scorer.getScore(), is(9));
    }

    @Test
    public void should_set_score_0() {
        Scorer scorer =new Scorer(5);

        scorer.setScore(0);
        assertThat(scorer.getScore(), is(0));
    }
}
