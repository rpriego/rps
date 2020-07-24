package com.ciklum.rps.dto;

public class TotalGamesDto {

    private final int totalGames;
    private final int totalWinsP1;
    private final int totalWinsP2;
    private final int totalDraws;

    public TotalGamesDto(int totalGames, int totalWinsP1, int totalWinsP2, int totalDraws) {
        this.totalGames = totalGames;
        this.totalWinsP1 = totalWinsP1;
        this.totalWinsP2 = totalWinsP2;
        this.totalDraws = totalDraws;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public int getTotalWinsP1() {
        return totalWinsP1;
    }

    public int getTotalWinsP2() {
        return totalWinsP2;
    }

    public int getTotalDraws() {
        return totalDraws;
    }
}
