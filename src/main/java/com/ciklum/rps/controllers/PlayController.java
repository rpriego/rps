package com.ciklum.rps.controllers;

import com.ciklum.rps.domain.Game;
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
    private UserGamesDto userGamesDto;

    @Autowired
    private GameService gameService;

    @GetMapping("/play")
    public String getPage(Model model) {
        model.addAttribute("userGamesDto", userGamesDto);
        return "play";
    }

    @PostMapping("/playGame")
    public String playGame(Model model) {
        Game game = gameService.playGame();
        userGamesDto.getUserGames().add(game);

        model.addAttribute("userGamesDto", userGamesDto);
        return "play :: #gamesSummary";
    }

    @PostMapping("/resetGame")
    public String resetGame(Model model) {
        userGamesDto.getUserGames().clear();

        model.addAttribute("userGamesDto", userGamesDto);
        return "play :: #gamesSummary";
    }

}
