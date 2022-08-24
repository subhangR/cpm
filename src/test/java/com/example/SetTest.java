package com.example;

import com.playm8s.cpm.models.core.enums.DistanceLevel;
import com.playm8s.cpm.models.dtos.matchmaking.MatchMakeRequest;
import com.playm8s.cpm.models.entities.common.Location;
import com.playm8s.cpm.models.entities.game.Lobby;
import com.playm8s.cpm.models.entities.game.LobbyPlayer;
import com.playm8s.cpm.models.entities.player.PlayerSettings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.discovery.SelectorResolver;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.persistence.Lob;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {


    @Test
    public void settest() {

        Set<Integer> set = new TreeSet<>();
        set.add(10);
        set.remove(10);
        Assertions.assertEquals(0,set.size());
    }

    @Test
    public void populate_data() {
        Location golfEdge = new Location(17.424103854447353,78.34773004418041);
        Location jeevanHouse = new Location(17.4683452385837, 78.33548116764914);
        Location kushalHouse = new Location(17.420549005312893, 78.38079362373402);
        Location manojHouse = new Location(17.424143278989295, 78.37654451579573);

        Location supremeBadminton = new Location(17.47125844581813, 78.33159237210077);
        Location pullalaGopiChand = new Location(17.438225488684022, 78.34908328393938);
        Location playTimeGachibowli = new Location(17.469739896159886, 78.35579243441298);
        Location smBadminton = new Location(17.461616781454843, 78.36245069008304);

        PlayerSettings busiSettings = PlayerSettings
                .builder()
                .playerId("busi")
                .currentCity(1)
                .location(golfEdge)
                .distanceLevel(DistanceLevel.MEDIUM)
                .build();
        PlayerSettings jeevanSettings = PlayerSettings
                .builder()
                .playerId("jeevan")
                .currentCity(1)
                .location(jeevanHouse)
                .distanceLevel(DistanceLevel.MEDIUM)
                .build();
        PlayerSettings kushalSettings = PlayerSettings
                .builder()
                .playerId("kushal")
                .currentCity(1)
                .location(kushalHouse)
                .distanceLevel(DistanceLevel.MEDIUM)
                .build();

        PlayerSettings manojSettings = PlayerSettings
                .builder()
                .playerId("manoj")
                .currentCity(1)
                .location(manojHouse)
                .distanceLevel(DistanceLevel.MEDIUM)
                .build();

        LobbyPlayer busi = new LobbyPlayer(busiSettings);
        LobbyPlayer jeevan = new LobbyPlayer(jeevanSettings);
        LobbyPlayer kushal = new LobbyPlayer(kushalSettings);
        LobbyPlayer manoj = new LobbyPlayer(manojSettings);

        List<LobbyPlayer> lobby1Players = new ArrayList<>();
        List<LobbyPlayer> lobby2Players = new ArrayList<>();
        List<LobbyPlayer> lobby3Players  = new ArrayList<>();
        List<LobbyPlayer> lobby4Players = new ArrayList<>();

        lobby1Players.add(busi);
        lobby2Players.add(jeevan);
        lobby3Players.add(kushal);
        lobby4Players.add(manoj);


        Lobby lobby1 = Lobby.builder()
                .lobbyPlayers(lobby1Players)
                .lobbyLeader(busi)
                .lobbyId("busi-lobby")
                .build();
        Lobby lobby2 = Lobby.builder()
                .lobbyPlayers(lobby2Players)
                .lobbyLeader(jeevan)
                .lobbyId("jeevan-lobby")
                .build();
        Lobby lobby3 = Lobby.builder()
                .lobbyPlayers(lobby3Players)
                .lobbyLeader(kushal)
                .lobbyId("kushal-lobby")
                .build();
        Lobby lobby4 = Lobby.builder()
                .lobbyPlayers(lobby4Players)
                .lobbyLeader(busi)
                .lobbyId("manoj-lobby")
                .build();

        MatchMakeRequest matchMakeRequest1 = MatchMakeRequest.builder()
                .matchMakeRequestId("request-1")
                .gameModeId("badminton_2_v_2")
                .lobby(lobby1)
                .build();
        MatchMakeRequest matchMakeRequest2 = MatchMakeRequest.builder()
                .matchMakeRequestId("request-2")
                .gameModeId("badminton_2_v_2")
                .lobby(lobby2)
                .build();
        MatchMakeRequest matchMakeRequest3 = MatchMakeRequest.builder()
                .matchMakeRequestId("request-3")
                .gameModeId("badminton_2_v_2")
                .lobby(lobby3)
                .build();
        MatchMakeRequest matchMakeRequest4 = MatchMakeRequest.builder()
                .matchMakeRequestId("request-4")
                .gameModeId("badminton_2_v_2")
                .lobby(lobby4)
                .build();

        List<MatchMakeRequest> matchMakeRequests = new ArrayList<>();
        matchMakeRequests.add(matchMakeRequest1);
        matchMakeRequests.add(matchMakeRequest2);
        matchMakeRequests.add(matchMakeRequest3);
        matchMakeRequests.add(matchMakeRequest4);
        matchMakeRequests.forEach(System.out::println);

    }
}
