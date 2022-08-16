package com.playm8s.cpm.models.entities.game;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Lobby {

        @JsonProperty("lobby_id")
        String lobbyId;


        @JsonProperty("lobby_leader")
        String lobbyLeader;

        @JsonProperty("other_players")
        List<LobbyPlayer> otherPlayers;

}
