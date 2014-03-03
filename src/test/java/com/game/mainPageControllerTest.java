package com.game;

import org.junit.Test;
import org.springframework.ui.ModelMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class mainPageControllerTest {
    @Test
    public void should_render_mainPage() {
        ModelMap model = new ModelMap();

        String returnView = new mainPageController().askMainPage(model);

        assertThat(returnView, is("mainPage"));
        assertThat((Game) model.get("game"), is(new Game()));
        assertThat((Integer) model.get("playerScore"), is(0));
    }
}
