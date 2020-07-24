package com.ciklum.rps.controllers;

import com.ciklum.rps.dto.TotalGamesDto;
import com.ciklum.rps.services.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TotalGamesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameServiceMock;

    @Test
    void getPageShouldAddBeanToModel() throws Exception {
        //given
        TotalGamesDto testDto = new TotalGamesDto(5,3,1,1);
        when(gameServiceMock.getTotals()).thenReturn(testDto);

        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/total"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("totalGamesDto", testDto));

    }

}