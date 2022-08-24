package com.playm8s.cpm.services.matchmaking;

import com.playm8s.cpm.models.dtos.matchmaking.MatchMakeRequest;

import java.util.*;
import java.util.stream.Collectors;

import com.playm8s.cpm.models.entities.court.CourtInventory;
import com.playm8s.cpm.models.entities.game.Lobby;
import com.playm8s.cpm.models.entities.game.LobbyPlayer;
import com.playm8s.cpm.models.entities.player.Player;
import com.playm8s.cpm.services.CourtService;
import com.playm8s.cpm.services.DistanceFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//assume only single game_mode_id

@Service
public class MatchMaker {

    @Autowired
    CourtService courtService;

    Logger log = LoggerFactory.getLogger(MatchMaker.class);
    HashMap<CourtInventory,Integer> possibleCourtLobbies;
    HashMap<Lobby,Integer> possibleLobbyCourts;

    HashMap<String,LobbyNode> lobbyNodeMap;

    HashMap<String,CourtInventoryNode> courtInventoryNode;


    Map<String,Player> playerMap;
    Map<Lobby,Set<CourtInventory>> lobbySuitableCourtsMap;
    Map<CourtInventory, Set<Lobby>> courtSuitableLobbiesMap;

    Set<CourtInventory> courtSet;

    public void findMatches(List<MatchMakeRequest> matchMakeRequests) {
        //
        List<String> playerIds = new ArrayList<>();
        lobbySuitableCourtsMap = new HashMap<>();
        TreeSet<CourtInventoryNode> liveCourtSet = new TreeSet<>(new CourtInventoryNodeComparator());
        List<CourtInventoryNode> deadCourts = new ArrayList<>();
        for(MatchMakeRequest matchMakeRequest : matchMakeRequests) {

            Lobby lobby = matchMakeRequest.getLobby();
            playerIds.addAll(
                    lobby.getLobbyPlayers().stream()
                            .map(LobbyPlayer::getPlayerId)
                            .collect(Collectors.toList())
            );

            Set<CourtInventory> lobbySuitableCourts = courtService.findLobbySuitableCourts(matchMakeRequest);

            for(CourtInventory court: lobbySuitableCourts) {
                Set<Lobby> courtLobbiesSet = courtSuitableLobbiesMap.containsKey(court) ? courtSuitableLobbiesMap.get(court) : new HashSet<>();
                courtLobbiesSet.add(lobby);
                courtSet.add(court);
                courtSuitableLobbiesMap.put(court,courtLobbiesSet);
            }
            lobbySuitableCourtsMap.put(lobby,lobbySuitableCourts);
        }

        //add all courts to priority queue based on number of available lobbies.
        courtSet.forEach(courtInventory -> {
           liveCourtSet.add(new CourtInventoryNode(courtInventory, courtSuitableLobbiesMap.get(courtInventory).size()));
        });

        playerMap = getPlayerMap(playerIds);

        while(!liveCourtSet.isEmpty()) {
            CourtInventoryNode courtInventoryNode = liveCourtSet.pollFirst();
            assert courtInventoryNode != null;
            Set<Lobby> lobbies = courtSuitableLobbiesMap.get(courtInventoryNode.getCourtInventory());
            Set<LobbyNode> lobbyNodes = lobbies.stream().map(lobby -> {
                return new LobbyNode(lobby,lobbySuitableCourtsMap.get(lobby).size());
            }).collect(Collectors.toSet());
            Set<Lobby> matchedLobbies = findMatchForCourt(courtInventoryNode.getCourtInventory(), lobbyNodes);
            if(matchedLobbies.size() == 0) {
                deadCourts.add(courtInventoryNode);
            }
            else {
                //For all the matched lobbies, find the possible courts and remove these lobbies from that court's possible lobbies.
                matchedLobbies.forEach(lobby -> {
                    Set<CourtInventory> courtInventories =   lobbySuitableCourtsMap.get(lobby);
                    courtInventories.forEach(courtInventory -> {
                       courtSuitableLobbiesMap.get(courtInventory).remove(lobby);
                        liveCourtSet.remove(new CourtInventoryNode(courtInventory));
                        liveCourtSet.add(new CourtInventoryNode(courtInventory, courtSuitableLobbiesMap.get(courtInventory).size()));
                    });
                });
            }
        }

    }

    Map<String,Player> getPlayerMap(List<String> playerIds) {
        //TODO
        return  null;
    }


    public Set<Lobby> findMatchForCourt(CourtInventory court, Set<LobbyNode> lobbyNodes) {

        LobbyNodeComparator lobbyNodeComparator = new LobbyNodeComparator();
        TreeSet<LobbyNode> threeLobbies = new TreeSet<>(lobbyNodeComparator);
        TreeSet<LobbyNode> twoLobbies = new TreeSet<>(lobbyNodeComparator);
        TreeSet<LobbyNode> oneLobbies = new TreeSet<>(lobbyNodeComparator);
        Set<Lobby> matchedLobbies = new HashSet<>();
        for(LobbyNode lobbyNode: lobbyNodes) {
            Lobby lobby = lobbyNode.getLobby();
            int playerCount = lobby.getPlayerCount();
            switch (playerCount) {
                case 4:
                    System.out.printf("MatchFound court=%s lobbyId=%s%n",court,lobby.getLobbyId());
                    matchedLobbies.add(lobby);
                    return matchedLobbies;
                case 3:
                    threeLobbies.add(new LobbyNode(lobbyNode.getLobby(), lobbySuitableCourtsMap.get(lobbyNode.getLobby()).size()));
                    break;
                case 2:
                    twoLobbies.add(new LobbyNode(lobbyNode.getLobby(),  lobbySuitableCourtsMap.get(lobbyNode.getLobby()).size()));
                    break;
                case 1:
                    oneLobbies.add(new LobbyNode(lobbyNode.getLobby(),  lobbySuitableCourtsMap.get(lobbyNode.getLobby()).size()));
                    break;
                default:
                    log.error("event=ExceptionalCase!!");
                    break;
            }
        }

        //Matching Three Lobbies.
        if(!threeLobbies.isEmpty() && !oneLobbies.isEmpty()) {
            Lobby threeLobby = threeLobbies.pollFirst().getLobby();
            Lobby oneLobby = oneLobbies.pollFirst().getLobby();
            log.info("event=MatchFound court={} threeLobby={} oneLobby={}",court,threeLobby,oneLobby);
            matchedLobbies.add(threeLobby);
            matchedLobbies.add(oneLobby);
            return matchedLobbies;
        }

        //Matching Two Lobbies
        if(!twoLobbies.isEmpty()) {
            Lobby twoLobby1 = twoLobbies.pollFirst().getLobby();
            if (twoLobbies.size() >= 1) {
                Lobby twoLobby2 = twoLobbies.pollFirst().getLobby();
                log.info("event=MatchFound court={} twoLobby1={} twoLobby2={}", court, twoLobby1, twoLobby2);
                matchedLobbies.add(twoLobby1);
                matchedLobbies.add(twoLobby2);
                return matchedLobbies;
            }
            if (oneLobbies.size() >= 2) {
                Lobby oneLobby1 = oneLobbies.pollFirst().getLobby();
                Lobby oneLobby2 = oneLobbies.pollFirst().getLobby();
                log.info("event=MatchFound court={} twoLobby={} oneLobby1={} oneLobby1={}", court, twoLobby1, oneLobby1, oneLobby2);
                matchedLobbies.add(twoLobby1);
                matchedLobbies.add(oneLobby1);
                matchedLobbies.add(oneLobby2);
                return matchedLobbies;
            }
        }

        if(oneLobbies.size() >= 4) {
            Lobby lobby1 = oneLobbies.pollFirst().getLobby();
            Lobby lobby2 = oneLobbies.pollFirst().getLobby();
            Lobby lobby3 = oneLobbies.pollFirst().getLobby();
            Lobby lobby4 = oneLobbies.pollFirst().getLobby();
            log.info("event-MatchFound court={} oneLobby1={} oneLobby2={} oneLobby3={} oneLobby4={}"
                    ,court,lobby1,lobby2,lobby3,lobby4);
            matchedLobbies.add(lobby1);
            matchedLobbies.add(lobby2);
            matchedLobbies.add(lobby3);
            matchedLobbies.add(lobby4);
            return matchedLobbies;
        }
        return matchedLobbies;
    }


}

