package com.ciklum.rps.services;

import com.ciklum.rps.domain.Game;
import com.ciklum.rps.repositories.GameTotalsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

import static com.ciklum.rps.domain.GameResult.*;
import static com.ciklum.rps.domain.Shape.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    @Mock
    private Random randomMock;

    @Mock
    private GameTotalsRepository gameTotalsRepositoryMock;

    @InjectMocks
    @Autowired
    private GameService underTest;

    @Test
    void createGameWithDefaultStrategyWillSelectRightOptions() {
        //given
        when(randomMock.nextInt(3)).thenReturn(1);

        //when
        Game game = underTest.createGameWithDefaultStrategy();

        //then
        assertThat(game.getPlayer1(), is(IShapeStrategy.random(randomMock).get()));
        assertThat(game.getPlayer2(), is(IShapeStrategy.rock().get()));
    }

    @Test
    void playRockShouldBeatScissors() {
        //given
        Game p1game = new Game(ROCK, SCISSORS);
        Game p2game = new Game(SCISSORS, ROCK);

        //when
        underTest.play(p1game);
        underTest.play(p2game);

        //then
        assertThat(p1game.getResult(), is(P1WINS));
        assertThat(p2game.getResult(), is(P2WINS));
    }

    @Test
    void playScissorsShouldBeatPaper() {
        //given
        Game p1game = new Game(SCISSORS, PAPER);
        Game p2game = new Game(PAPER, SCISSORS);

        //when
        underTest.play(p1game);
        underTest.play(p2game);

        //then
        assertThat(p1game.getResult(), is(P1WINS));
        assertThat(p2game.getResult(), is(P2WINS));
    }

    @Test
    void playPaperShouldBeatRock() {
        //given
        Game p1game = new Game(PAPER, ROCK);
        Game p2game = new Game(ROCK, PAPER);

        //when
        underTest.play(p1game);
        underTest.play(p2game);

        //then
        assertThat(p1game.getResult(), is(P1WINS));
        assertThat(p2game.getResult(), is(P2WINS));
    }

    @Test
    void playEqualShapesDraw() {
        //given
        Game rockGame = new Game(ROCK, ROCK);
        Game paperGame = new Game(PAPER, PAPER);
        Game scissorsGame = new Game(SCISSORS, SCISSORS);

        //when
        underTest.play(rockGame);
        underTest.play(paperGame);
        underTest.play(scissorsGame);

        //then
        assertThat(rockGame.getResult(), is(DRAW));
        assertThat(paperGame.getResult(), is(DRAW));
        assertThat(scissorsGame.getResult(), is(DRAW));
    }

    @Test
    void playGameShouldCreateDefaultPlayItAndSaveTotals() {
        //given
        GameService spy = Mockito.spy(underTest);
        Game game = new Game(PAPER, ROCK);
        doReturn(game).when(spy).createGameWithDefaultStrategy();

        //when
        spy.playGame();

        //then
        Mockito.verify(spy, times(1)).createGameWithDefaultStrategy();
        Mockito.verify(spy).play(game);
        Mockito.verify(gameTotalsRepositoryMock, times(1)).saveGameResult(game.getResult());
    }
}