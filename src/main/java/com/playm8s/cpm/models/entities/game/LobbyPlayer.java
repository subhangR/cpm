package com.playm8s.cpm.models.entities.game;

import com.playm8s.cpm.models.entities.player.UserSettings;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
public class LobbyPlayer {

    public LobbyPlayer(UserSettings userSettings) {
        this.userSettings = userSettings;
        this.userId = userSettings.getUserId();
    }
    String userId;
    UserSettings userSettings;


}
