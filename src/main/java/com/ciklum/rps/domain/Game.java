package com.ciklum.rps.domain;

public class Game {

    private final Shape player1;
    private final Shape player2;
    private GameResult result;

    public Game(Shape player1, Shape player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Shape getPlayer1() {
        return player1;
    }

    public Shape getPlayer2() {
        return player2;
    }

    public GameResult getResult() {
        return result;
    }

    public void setResult(GameResult result) {
        this.result = result;
    }
}
