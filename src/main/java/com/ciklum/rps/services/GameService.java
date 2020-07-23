package com.ciklum.rps.services;

import com.ciklum.rps.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class GameService {

    @Autowired
    Random random;

    public Game playGame() {
        Game game = createGameWithDefaultStrategy();
        play(game);
        return game;
    }

    Game createGameWithDefaultStrategy() {
        return null;
    }

    void play(Game game) {
    }
}
