package com.ciklum.rps.repositories;

import com.ciklum.rps.domain.GameResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
class GameTotalsRepositoryTest {

    @Autowired
    private GameTotalsRepository underTest;

    @Test
    void saveGameShouldBeThreadSafeAndRetrieveRightTotals() throws InterruptedException {
        final int numIterations = 1000;
        final int numThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for(int i=0; i<numIterations; i++) {
            executor.submit(() -> underTest.saveGameResult(GameResult.P1WINS));
            executor.submit(() -> underTest.saveGameResult(GameResult.P2WINS));
            executor.submit(() -> underTest.saveGameResult(GameResult.DRAW));
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        assertThat(underTest.getTotals().getTotalGames(), is(3000));
        assertThat(underTest.getTotals().getTotalWinsP1(), is(1000));
        assertThat(underTest.getTotals().getTotalWinsP2(), is(1000));
        assertThat(underTest.getTotals().getTotalDraws(), is(1000));

    }


}