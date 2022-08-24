package com.playm8s.cpm.models.entities.game;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.playm8s.cpm.models.entities.common.Location;
import com.playm8s.cpm.models.entities.player.PlayerSettings;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class LobbyPlayer {

    public LobbyPlayer(PlayerSettings playerSettings) {
        this.playerSettings = playerSettings;
        this.playerId = playerSettings.getPlayerId();
    }
    String playerId;


    PlayerSettings playerSettings;

}
