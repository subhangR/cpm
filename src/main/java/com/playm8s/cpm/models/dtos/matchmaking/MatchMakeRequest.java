package com.playm8s.cpm.models.dtos.matchmaking;

/*

{


	"game_lobby" : {

		"other_players" : [
          {"player_id" : "kushal", "player_location" : "12q3213L, a213123M", "player_settings" : {"distance_settings" : "MEDIUM"}},

	}

}
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.playm8s.cpm.models.entities.game.Lobby;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchMakeRequest {
    String requestId;

    String gameModeId;

    Lobby lobby;

    int numBots;
    public String get_id() {
        return requestId;
    }
    public void set_id(String id) {
        this.requestId = id;
    }

}
