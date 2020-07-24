package com.ciklum.rps.controllers;

import com.ciklum.rps.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TotalGamesController {

    @Autowired
    private GameService gameService;

    @GetMapping("/total")
    public String getPage(Model model) {
        return null;
    }

}
