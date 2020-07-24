package com.ciklum.rps.dto;

import com.ciklum.rps.domain.Game;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserGamesDto {

    private List<Game> userGames;

    public UserGamesDto() {
        userGames = new ArrayList<>();
    }

    public List<Game> getUserGames() {
        return userGames;
    }

    public void setUserGames(List<Game> userGames) {
        this.userGames = userGames;
    }
}
