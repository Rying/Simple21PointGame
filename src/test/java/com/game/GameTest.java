package com.game;

import org.junit.Before;
import org.junit.Test;


import java.lang.reflect.Field;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    Cards cards;
    Game game;

    @Test
    public void should_player_get_one_card() {
        Game game = new Game();
        game.addOneCardPathToPlayerCards(new Card("5", "Club"));
        assertThat(game.getPlayerCards().get(0), is(new Card("5", "Club").getCardPath()));
    }

    @Test
    public void should_start_player_cards_paths_contains_2() {
        Game game = new Game();

        game.start();

        assertThat(game.getPlayerCards().size(), is(2));
    }

    @Test
    public void should_start_host_cards_paths_contains_2() {
        Game game = new Game();

        game.start();

        assertThat(game.getHostCards().size(), is(2));
    }

    @Test
    public void should_start_role_is_player() {
        Game game = new Game();
        game.setRole(Role.HOST);
        game.start();
        assertThat(game.getRole(), is(Role.PLAYER));
    }

    @Before
    public void setUp() throws Exception {
        cards = mock(Cards.class);

        when(cards.getCard(0)).thenReturn(new Card("5", "Club"));
        when(cards.getCard(1)).thenReturn(new Card("4", "Club"));
        when(cards.getCard(2)).thenReturn(new Card("5", "Club"));
        when(cards.getCard(3)).thenReturn(new Card("4", "Spade"));

        game = new Game();
    }

    @Test
    public void should_start_player_score_not_0() {
        game.start();

        assertThat(game.getPlayerScore(), not(0));
    }

    @Test
    public void should_start_player_card_paths_are_stick_small() {
        game.start();

        assertThat(game.getPlayerCards().get(0), is("images/images/stick_small.jpg"));
        assertThat(game.getPlayerCards().get(1), is("images/images/stick_small.jpg"));
    }

    @Test
    public void should_start_cards_reshuffled() {
        game.start();

        assertThat(game.getPlayerScore(), not(1));
    }

    @Test
    public void should_player_hit_get_score_and_get_card_path() {
        try {
            Field gameField = game.getClass().getDeclaredField("cards");
            gameField.setAccessible(true);
            gameField.set(game, cards);

            gameField = game.getClass().getDeclaredField("cardsIndex");
            gameField.setAccessible(true);
            gameField.set(game, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        game.hit();

        assertThat(game.getPlayerScore(), is(5));
        assertThat(game.getPlayerCards().get(0), is(cards.getCard(0).getCardPath()));
    }

    @Test
    public void should_player_stay_role_is_host() {
        Game game = new Game();
        game.stay();
        assertThat(game.getRole(), is(Role.HOST));
    }

    @Test
    public void should_host_hit_get_score_and_get_card_path() {
        try {
            Field gameField = game.getClass().getDeclaredField("cards");
            gameField.setAccessible(true);
            gameField.set(game, cards);

            gameField = game.getClass().getDeclaredField("cardsIndex");
            gameField.setAccessible(true);
            gameField.set(game, 0);

            gameField = game.getClass().getDeclaredField("role");
            gameField.setAccessible(true);
            gameField.set(game, Role.HOST);
        } catch (Exception e) {
            e.printStackTrace();
        }

        game.hit();
        assertThat(game.getHostScore(), is(5));
        assertThat(game.getHostCards().get(0), is(cards.getCard(0).getCardPath()));
    }
}