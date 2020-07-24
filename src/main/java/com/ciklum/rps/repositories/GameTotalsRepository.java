package com.ciklum.rps.repositories;

import com.ciklum.rps.domain.GameResult;
import com.ciklum.rps.dto.TotalGamesDto;
import org.springframework.stereotype.Repository;

@Repository
public class GameTotalsRepository {
    private int totalGames;
    private int totalWinsP1;
    private int totalWinsP2;
    private int totalDraws;

    public TotalGamesDto getTotals() {
        return null;
    }

    public void saveGameResult(GameResult gameResult) {

    }
}
