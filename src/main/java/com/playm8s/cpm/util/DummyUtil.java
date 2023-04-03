package com.playm8s.cpm.util;

import com.playm8s.cpm.models.core.enums.DistanceLevel;
import com.playm8s.cpm.models.dtos.matchmaking.MatchMakeRequest;
import com.playm8s.cpm.models.entities.common.Location;
import com.playm8s.cpm.models.entities.court.Arena;
import com.playm8s.cpm.models.entities.court.Court;
import com.playm8s.cpm.models.entities.game.Game;
import com.playm8s.cpm.models.entities.game.Lobby;
import com.playm8s.cpm.models.entities.game.LobbyPlayer;
import com.playm8s.cpm.models.entities.game.modes.GameMode;
import com.playm8s.cpm.models.entities.player.User;
import com.playm8s.cpm.models.entities.player.UserSettings;

import java.util.*;
import java.util.stream.Collectors;

public class DummyUtil {

    public static MatchMakeRequest getRandomMatchMakeRequest() {

        MatchMakeRequest matchMakeRequest = MatchMakeRequest
                .builder()
                .requestId(UUID.randomUUID().toString())
                .gameModeId("badminton_2_v_2")
                .lobby(getDummyLobby())
                .build();
        return matchMakeRequest;
    }

    public static List<MatchMakeRequest> getDummyRequests() {
        MatchMakeRequest matchMakeRequest1 = MatchMakeRequest
                .builder()
                .requestId(UUID.randomUUID().toString())
                .gameModeId("badminton_2_v_2")
                .lobby(getLobby(List.of("jeevan","kushal")))
                .build();

        MatchMakeRequest matchMakeRequest2 = MatchMakeRequest
                .builder()
                .requestId(UUID.randomUUID().toString())
                .gameModeId("badminton_2_v_2")
                .lobby(getLobby(List.of("busi")))
                .build();

        MatchMakeRequest matchMakeRequest3 = MatchMakeRequest
                .builder()
                .requestId(UUID.randomUUID().toString())
                .gameModeId("badminton_2_v_2")
                .lobby(getLobby(List.of("vishnu")))
                .build();
        List<MatchMakeRequest> matchMakeRequestList = new ArrayList<>();
        matchMakeRequestList.add(matchMakeRequest1);
        matchMakeRequestList.add(matchMakeRequest2);
        matchMakeRequestList.add(matchMakeRequest3);
        return matchMakeRequestList;


    }



    public static Lobby getLobby(List<String> userNames) {
        if(userNames.size() == 0) return null;
        List<LobbyPlayer> lobbyPlayers = new ArrayList<>();
        userNames.forEach(userName -> {
            UserSettings us = userSettingsMap(userMap()).get(userName);
            lobbyPlayers.add(new LobbyPlayer(us));
        });
        return Lobby.builder()
                .lobbyId(UUID.randomUUID().toString())
                .lobbyPlayers(lobbyPlayers)
                .lobbyLeader(lobbyPlayers.get(0))
                .build();
    }


    public static Map<String,Location> userLocationMap() {
        Map<String,Location> locationMap = new HashMap<>();
        locationMap.put("kushal", new Location(17.41122907069457, 78.37531088441249));
        locationMap.put("vishnu", new Location(17.46763119759139, 78.26375051470522));
        locationMap.put("jeevan",new Location(17.467842813753247, 78.31195107726062));
        locationMap.put("bharat",new Location(17.4610272736494, 78.30762057656469));
        locationMap.put("xeno_platina",new Location(17.46943992997339, 78.34293160903641));
        locationMap.put("aditya_heights",new Location(17.45561317919203, 78.3645808243778));
        locationMap.put("bhargav",new Location(17.433360218282715, 78.36660970827351));
        locationMap.put("krishna",new Location(17.433360218282715, 78.36660970827351));
        locationMap.put("siddharth", new Location(17.42433303431861, 78.34759609190202));
        locationMap.put("busi",new Location(17.42433303431861, 78.34759609190202));
        locationMap.put("subhang",new Location(17.42433303431861, 78.34759609190202));
        locationMap.put("gopanapally",new Location(17.44867300959758, 78.30611910304097));
        return locationMap;
    }

    public static Map<String,Location> arenasLocationMap() {
        Map<String,Location> courtLocationMap = new HashMap<>();
        courtLocationMap.put("wipro_court",new Location(17.425703092585213, 78.34044409629745));
        courtLocationMap.put("botanical_court",new Location(17.45841393400299, 78.35708192212911));
        courtLocationMap.put("madhapur_court",new Location(17.456322587334085, 78.38629667724743));
        courtLocationMap.put("madhapur_court2",new Location(17.450017885183176, 78.39539472967891));
        courtLocationMap.put("pullela_gopichand",new Location(17.438412288388683, 78.34914348389637));
        courtLocationMap.put("sai_gopichand",new Location(17.43791328962641, 78.36179079739009));
        return courtLocationMap;
    }

    public static Map<String,Location> nearestCourtForEachUserLocation(Map<String,Location> locationMap,Map<String,Location> courtMap) {
        Map<String,Location> nearestCourtMap = new HashMap<>();
        locationMap.forEach((userName,location) -> {
            Location nearestCourt = courtMap.entrySet().stream()
                    .min(Comparator.comparingDouble(entry -> entry.getValue().distance(location)))
                    .get().getValue();
            nearestCourtMap.put(userName,nearestCourt);
        });
        return nearestCourtMap;
    }


    public static Lobby getDummyLobby() {
        List<LobbyPlayer> lobbyPlayers = getDummyLobbyPlayers(4);
        Lobby lobby = Lobby.builder()
                .lobbyId(UUID.randomUUID().toString())
                .lobbyLeader(lobbyPlayers.get(0))
                .lobbyPlayers(lobbyPlayers)
                .build();
        return lobby;
    }

    public static List<LobbyPlayer> getLobbyPlayers(int n) {
        Map<String,UserSettings> userSettingsMap = userSettingsMap(userMap());
        if(userSettingsMap.entrySet().size() > n) {
            throw new RuntimeException("Too Many Players!");
        }
        List<LobbyPlayer> lobbyPlayers  = new ArrayList<>();
        for(int i = 0;i < n;i++) {
            lobbyPlayers.add(new LobbyPlayer(userSettingsMap.entrySet().iterator().next().getValue()));
        }
        return lobbyPlayers;
    }

    public static List<LobbyPlayer> getDummyLobbyPlayers(int n) {
        LobbyPlayer p1 = getBotPlayer();
        LobbyPlayer p2 = getBotPlayer();
        LobbyPlayer p3 = getBotPlayer();
        LobbyPlayer p4 = getBotPlayer();
        List<LobbyPlayer> playerList = new ArrayList<>();
        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        playerList.add(p4);
        return playerList;
    }


    public static LobbyPlayer getBotPlayer() {
        String userId = getBotUserId();
        UserSettings userSettings =  UserSettings.builder()
                                        .userId(userId)
                                        .currentCity(1)
                                        .distanceLevel(DistanceLevel.MEDIUM)
                                        .location(new Location(123.2123,123123.123))
                                        .build();
        LobbyPlayer lobbyPlayer = new LobbyPlayer(userSettings);
        return lobbyPlayer;
    }


    public static Map<String,User> userMap() {
        Map<String,Location> userLocationMap = userLocationMap();
        return userLocationMap.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,e -> createUser(e.getKey())));
    }

    public static Map<String,UserSettings> userSettingsMap(Map<String,User> userMap) {
        Map<String,Location> userLocationMap = userLocationMap();
        return userMap.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e -> createUserSettings(e.getKey()
                                ,userLocationMap.get(e.getValue().getName()))));
    }


    public static Map<String, Arena> arenasMap() {
        Map<String,Location> arenaLocationMap = arenasLocationMap();
        return arenaLocationMap.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey
                        ,e -> getArena(e.getKey(),e.getValue())));
    }

    public static Arena getArena(String name, Location location) {
        String arenaId = UUID.randomUUID().toString();
        return Arena.builder()
                .arenaId(arenaId)
                .contactNumber("7091171999")
                .location(location)
                .name(name)
                .courts(getCourts(arenaId,location))
                .build();
    }

    public static List<Court> getCourts(String arenaId, Location location) {
        List<Court> courts = new ArrayList<>();
        for(int i = 0;i < 5;i++) {
            courts.add(Court.builder()
                            .courtId(UUID.randomUUID().toString())
                            .arenaId(arenaId)
                            .name("court-"+i)
                            .location(location)
                            .supportedGameModes(gameModes())
                    .build());
        }
        return courts;
    }

    public static List<GameMode> gameModes() {
        List<GameMode> gameModes = new ArrayList<>();
        gameModes.add(GameMode.builder()
                        .name("badminton_2v2")
                        .description("badminton_2V2")
                        .numOfPlayers(4)
                        .rules("play properly")
                        .gameModeId("badminton_2v2")
                        .build());
        return gameModes;
    }
    private static User createUser(String name) {
        return User.builder()
                .userId(UUID.randomUUID().toString())
                .age(27)
                .heightInInches(30)
                .weight(80)
                .phone("7091171999")
                .name(name)
                .build();
    }

    private static UserSettings createUserSettings(String userId,Location location) {
        return UserSettings.builder()
                .userId(userId)
                .currentCity(1)
                .distanceLevel(DistanceLevel.MEDIUM)
                .location(location)
                .build();
    }


    public static String getBotUserId() {
        return "bot_user_"+UUID.randomUUID().toString();
    }


}
