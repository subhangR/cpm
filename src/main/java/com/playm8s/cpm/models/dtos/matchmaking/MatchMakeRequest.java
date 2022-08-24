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
import com.playm8s.cpm.models.entities.common.Location;
import com.playm8s.cpm.models.entities.game.Lobby;
import com.playm8s.cpm.models.entities.player.PlayerSettings;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MatchMakeRequest {

    String matchMakeRequestId;

    String gameModeId;

    Lobby lobby;

}
