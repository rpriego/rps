package com.ciklum.rps.repositories;

import com.ciklum.rps.domain.GameResult;
import com.ciklum.rps.dto.TotalGamesDto;
import org.springframework.stereotype.Service;

@Service
public class GameTotalsRepository {
    private int totalGames = 0;
    private int totalWinsP1 = 0;
    private int totalWinsP2 = 0;
    private int totalDraws = 0;

    public synchronized TotalGamesDto getTotals() {
        return new TotalGamesDto(totalGames, totalWinsP1, totalWinsP2, totalDraws);
    }

    public synchronized void saveGameResult(GameResult gameResult) {
        totalGames++;

        switch(gameResult) {
            case P1WINS:
                totalWinsP1++;
                break;
            case P2WINS:
                totalWinsP2++;
                break;
            case DRAW:
                totalDraws++;
                break;
        }
    }
}
