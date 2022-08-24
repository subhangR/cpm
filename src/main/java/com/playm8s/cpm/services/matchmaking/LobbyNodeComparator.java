package com.playm8s.cpm.services.matchmaking;

import com.playm8s.cpm.models.entities.game.Lobby;

import java.util.Comparator;

public class LobbyNodeComparator implements Comparator<LobbyNode> {


    @Override
    public int compare(LobbyNode o1, LobbyNode o2) {
        if( o1.getPossibleCourtInventories() < o2.getPossibleCourtInventories()) {
            return -1;
        }
        else if(o1.getPossibleCourtInventories() > o2.getPossibleCourtInventories()) {
            return 1;
        }
        return 0;
    }
}
