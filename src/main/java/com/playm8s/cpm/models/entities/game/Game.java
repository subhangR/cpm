package com.playm8s.cpm.models.entities.game;

import com.playm8s.cpm.models.dtos.matchmaking.MatchMakeRequest;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Data
@Getter
@Setter
@NoArgsConstructor
public class Game {

    String gameId;

    String gameModeId;

    String userId;

    Lobby lobby;

    MatchMakeRequest matchMakeRequest;

    List<MatchMakeRequest> allMatchMakeRequests;

    String courtId;

    LocalDate startTime;

    LocalDate endTime;

    GameStatus status;
    public String get_id() {
        return gameId;
    }
    public void set_id(String id) {
        this.gameId = id;
    }

}
