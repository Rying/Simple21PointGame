package com.game;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class Simple21PointGameTest {
    @Test
    public void should_start_player_score_is_not_0() {
        Simple21PointGame simple21PointGame = new Simple21PointGame();
        simple21PointGame.start();

        assertThat(simple21PointGame.getRole().PLAYER.getScore(), not(0));
    }

    @Test
    public void should_start_host_score_is_not_0() {
        Simple21PointGame simple21PointGame = new Simple21PointGame();

        simple21PointGame.start();

        assertThat(simple21PointGame.getRole().HOST.getScore(), not(0));
    }

    @Test
    public void should_start_player_cards_path_correct() {
        Simple21PointGame simple21PointGame = new Simple21PointGame();

        simple21PointGame.start();

        assertThat(simple21PointGame.getRole().PLAYER.getCards().get(0), is("/images/stick_small.jpg"));
    }

    @Test
    public void should_start_cards_index_4() {
        Simple21PointGame simple21PointGame = new Simple21PointGame();

        simple21PointGame.start();

        try {
            Field field = simple21PointGame.getClass().getDeclaredField("cardsIndex");
            field.setAccessible(true);
            assertThat(field.getInt(simple21PointGame), is(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_start_role_is_player() {
        Simple21PointGame simple21PointGame = new Simple21PointGame();

        simple21PointGame.start();

        assertThat(simple21PointGame.getRole(), is(Role.PLAYER));
    }

    @Test
    public void should_player_hit_card_get_correct_score() {
        Simple21PointGame simple21PointGame = new Simple21PointGame();

        simple21PointGame.setRole(Role.PLAYER);
        simple21PointGame.hit();

        assertThat(simple21PointGame.getRole().getScore(), not(0));
    }

    @Test
    public void should_player_hit_card_get_correct_img_path() {
        Simple21PointGame simple21PointGame = new Simple21PointGame();

        simple21PointGame.setRole(Role.PLAYER);
        simple21PointGame.hit();

        int size = simple21PointGame.getCardPaths().size();
        assertThat(simple21PointGame.getCardPaths().get(size - 1), is(new Card("A", "Club").getCardPath()));
    }

    @Test
    public void should_player_stay_role_is_host() {
        Simple21PointGame simple21PointGame = new Simple21PointGame();

        simple21PointGame.setRole(Role.PLAYER);
        simple21PointGame.stay();

        assertThat(simple21PointGame.getRole(), is(Role.HOST));
    }

    @Test
    public void should_player_score_22_host_win() {
        Simple21PointGame simple21PointGame = new Simple21PointGame();

        simple21PointGame.checkResult(22, 6);

        assertThat(simple21PointGame.getResult(), is("Host win!"));
    }

    @Test
    public void should_clean_game_state_refreshed() {
        Simple21PointGame simple21PointGame = new Simple21PointGame();

        simple21PointGame.start();
        simple21PointGame.clean();

        assertThat(simple21PointGame, is(new Simple21PointGame()));
    }
}

