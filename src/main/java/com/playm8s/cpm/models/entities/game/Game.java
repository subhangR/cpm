package com.playm8s.cpm.models.entities.game;

import com.playm8s.cpm.models.dtos.matchmaking.MatchMakeRequest;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@Getter
@Setter
@NoArgsConstructor
public class Game {

    String gameId;

    String gameModeId;

    String playerId;

    Lobby lobby;

    MatchMakeRequest matchMakeRequest;

    List<MatchMakeRequest> allMatchMakeRequests;

    String courtId;

    LocalDate startTime;

    LocalDate endTime;

    @Enumerated(EnumType.ORDINAL)
    GameStatus status;

}
