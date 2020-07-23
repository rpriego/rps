package com.ciklum.rps.controllers;

import com.ciklum.rps.dto.UserGamesDto;
import com.ciklum.rps.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlayController {

    @Autowired
    UserGamesDto userGames;

    @Autowired
    GameService gameService;

    @GetMapping("/play")
    public String getPage(Model model) {
        return null;
    }

    @PostMapping("/playGame")
    public String playGame(Model model) {
        return null;
    }

    @PostMapping("/resetGame")
    public String resetGame(Model model) {
        return null;
    }

}
