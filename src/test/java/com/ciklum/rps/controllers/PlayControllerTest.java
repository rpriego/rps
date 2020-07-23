package com.ciklum.rps.controllers;

import com.ciklum.rps.domain.Game;
import com.ciklum.rps.dto.UserGamesDto;
import com.ciklum.rps.services.GameService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static com.ciklum.rps.domain.Shape.PAPER;
import static com.ciklum.rps.domain.Shape.ROCK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PlayControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserGamesDto userGamesMock;

    @Mock
    GameService gameServiceMock;

    Game testGame = new Game(ROCK, PAPER);

    @Test
    void getPageShouldAddBeanToModel() throws Exception {
        //given
        when(userGamesMock.getUserGames()).thenReturn(new ArrayList<>());

        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/play"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("userGames", userGamesMock));

    }

    @Test
    void playGameShouldAddGameToSessionBean() throws Exception {
        //given
        List<Game> userGamesList = new ArrayList<>();
        when(userGamesMock.getUserGames()).thenReturn(userGamesList);
        when(gameServiceMock.playGame()).thenReturn(testGame);

        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/playGame"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("userGames", userGamesMock));

        //then
        assertThat(userGamesList.size(), is(1));
        assertThat(userGamesList.get(0), is(testGame));
        verify(gameServiceMock, times(1)).playGame();
    }


    @Test
    void resetGameShouldDeleteGamesList() throws Exception {
        //given
        List<Game> userGamesList = new ArrayList<>();
        userGamesList.add(testGame);
        when(userGamesMock.getUserGames()).thenReturn(userGamesList);

        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/resetGame"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("userGames", userGamesMock));

        //then
        assertThat(userGamesList.size(), is(0));
    }
}