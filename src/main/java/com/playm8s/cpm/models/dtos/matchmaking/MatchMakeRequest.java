package com.playm8s.cpm.models.dtos.matchmaking;

/*

{


	"game_lobby" : {

		"other_players" : [
          {"player_id" : "kushal", "player_location" : "12q3213L, a213123M", "player_settings" : {"distance_settings" : "MEDIUM"}},

	}

}
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.playm8s.cpm.models.entities.game.Lobby;
import com.playm8s.cpm.models.entities.player.PlayerGameSettings;
import com.playm8s.cpm.models.entities.player.PlayerSettings;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MatchMakeRequest {

    @JsonProperty("player_id")
    String playerId;

    @JsonProperty("game_mode_id")
    String gameModeId;

    @JsonProperty("start_location")
    String startLocation;

    @JsonProperty("player_settings")
    PlayerSettings playerSettings;

    @JsonProperty("player_game_settings")
    PlayerGameSettings playerGameSettings;

    @JsonProperty("lobby_details")
    Lobby lobbyDetails;

}
