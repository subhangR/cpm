package com.playm8s.cpm.models.entities.game;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.playm8s.cpm.models.entities.common.Location;
import com.playm8s.cpm.models.entities.player.PlayerSettings;

public class LobbyPlayer {

    @JsonProperty("player_id")
    String playerId;

    @JsonProperty("player_location")
    Location location;

    @JsonProperty("player_settings")
    PlayerSettings playerSettings;



}
