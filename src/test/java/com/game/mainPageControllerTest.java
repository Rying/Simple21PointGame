package com.game;


import org.junit.Test;
import org.springframework.ui.ModelMap;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

public class mainPageControllerTest {
    @Test
    public void should_render_mainPage_return_correct_string() {
        ModelMap modelMap = new ModelMap();
        String result = new MainPageController().askMainPage(modelMap);
        assertThat(result, is("mainPage"));
    }

    @Test
    public void should_render_mainPage_add_attribute_to_model() {
        ModelMap modelMap = new ModelMap();
        new MainPageController().askMainPage(modelMap);
        assertThat((String) modelMap.get("result"), is(""));
    }
}
