package com.ciklum.rps.services;

import com.ciklum.rps.domain.Game;
import com.ciklum.rps.domain.Shape;
import com.ciklum.rps.repositories.GameTotalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

import static com.ciklum.rps.domain.GameResult.*;

@Service
public class GameService {

    @Autowired
    private Random random;

    @Autowired
    private GameTotalsRepository gameTotalsRepository;

    public Game playGame() {
        Game game = createGameWithDefaultStrategy();
        play(game);
        return game;
    }

    Game createGameWithDefaultStrategy() {
        return new Game(IShapeStrategy.random(random).get(), IShapeStrategy.rock().get());
    }

    void play(Game game) {
        if(game.getPlayer1() == game.getPlayer2()) {
            game.setResult(DRAW);
        } else if((game.getPlayer1() == Shape.ROCK && game.getPlayer2() == Shape.SCISSORS) ||
                (game.getPlayer1() == Shape.SCISSORS && game.getPlayer2() == Shape.PAPER) ||
                (game.getPlayer1() == Shape.PAPER && game.getPlayer2() == Shape.ROCK)) {
            game.setResult(P1WINS);
        } else {
            game.setResult(P2WINS);
        }
    }
}
