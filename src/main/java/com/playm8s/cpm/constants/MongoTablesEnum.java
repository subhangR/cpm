package com.playm8s.cpm.constants;

import com.playm8s.cpm.models.dtos.matchmaking.MatchMakeRequest;
import com.playm8s.cpm.models.entities.common.Location;
import com.playm8s.cpm.models.entities.court.Arena;
import com.playm8s.cpm.models.entities.court.Court;
import com.playm8s.cpm.models.entities.game.Game;
import com.playm8s.cpm.models.entities.game.Sport;
import com.playm8s.cpm.models.entities.game.modes.GameMode;
import com.playm8s.cpm.models.entities.player.User;
import com.playm8s.cpm.models.entities.player.UserSettings;

public enum MongoTablesEnum {
        USERS_COLLECTION("users"),
        USER_SETTINGS_COLLECTION("user_settings"),
        MATCH_REQUESTS("match_requests"),
        ARENAS("arenas"),
        COURTS("courts"),
        GAMES("games"),
        SPORTS("sports"),
        GAME_MODES("game_modes"),
        LOCATIONS("locations");
        private String value;

        MongoTablesEnum(String value) {
                this.value= value;
        }
        public String getTableName() {
                return this.value;
        }
        public Class getKlass() {
                switch(value) {
                        case "users":
                                return User.class;
                        case "user_settings":
                                return UserSettings.class;
                        case "match_requests":
                                return MatchMakeRequest.class;
                        case "arenas":
                                return Arena.class;
                        case "courts":
                                return Court.class;
                        case "games":
                                return Game.class;
                        case "sports":
                                return Sport.class;
                        case "game_modes":
                                return GameMode.class;
                        case "locations":
                                return Location.class;
                        default:
                                return null;
                }
        }
}
