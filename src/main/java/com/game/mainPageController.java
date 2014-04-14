package com.game;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Random;


@Controller
@RequestMapping("/mainPage")
public class MainPageController {
    Simple21PointGame game;

    public MainPageController() {
        game = new Simple21PointGame();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String askMainPage(ModelMap model) {
        game = new Simple21PointGame();
        addAttributes(model);
        return "mainPage";
    }

    private void addAttributes(ModelMap model) {
        model.addAttribute("result", game.getResult());
        model.addAttribute("playerScore", game.getRole().PLAYER.getScore());
        model.addAttribute("hostScore", game.getRole().HOST.getScore());
        model.addAttribute("playerCardPaths", game.getRole().PLAYER.getCards());
        model.addAttribute("hostCardPaths", game.getRole().HOST.getCards());
    }

    @RequestMapping(params = "method=Start")
    public String Start(ModelMap model) {
        game.start();

        addAttributes(model);

        return "mainPage";
    }

    @RequestMapping(params = "method=Hit")
    public String Hit(ModelMap model) {
        game.hit();

        addAttributes(model);

        return "mainPage";
    }

    @RequestMapping(params = "method=Stay")
    public String Stay(ModelMap model) throws InterruptedException {
        game.stay();
        Random random = new Random();

        while (random.nextInt(10) % 2 == 0) {
            game.hit();
            wait(2000);
        }
        game.stay();

        addAttributes(model);
        return "mainPage";
    }

}
