package com.game;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/mainPage")
public class mainPageController {
    Game game;

    public mainPageController() {
        game = new Game();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String askMainPage(ModelMap model) {
        game = new Game();
        model.addAttribute("game", game);
        model.addAttribute("playerScore", game.getPlayerScore());
        model.addAttribute("hostScore", game.getHostScore());
        return "mainPage";
    }

    @RequestMapping(params = "method=Start")
    public String Start(ModelMap model) {
        game.start();
        model.addAttribute("game", game);
        model.addAttribute("playerScore", game.getPlayerScore());
        model.addAttribute("hostScore", game.getHostScore());
        return "mainPage";
    }

    @RequestMapping(params = "method=Hit")
    public String Hit(ModelMap model) {
        game.hit();
        model.addAttribute("game", game);
        model.addAttribute("playerScore", game.getPlayerScore());
        model.addAttribute("hostScore", game.getHostScore());
        return "mainPage";
    }

    @RequestMapping(params = "method=Stay")
    public String Stay(ModelMap model) {
        game.stay();
        model.addAttribute("game", game);
        model.addAttribute("playerScore", game.getPlayerScore());
        model.addAttribute("hostScore", game.getHostScore());
        return "mainPage";
    }
}
