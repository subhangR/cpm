package com.playm8s.cpm.services;

import com.playm8s.cpm.models.dtos.matchmaking.MatchMakeRequest;
import com.playm8s.cpm.models.entities.common.Location;
import com.playm8s.cpm.models.entities.court.CourtInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourtService {

    @Autowired
    DistanceFinder distanceFinder;

    public List<CourtInventory> getAllCourts() {
        return new ArrayList<>();
    }

    public Set<CourtInventory> findLobbySuitableCourts(MatchMakeRequest matchMakeRequest) {
        List<CourtInventory> courts = getAllCourts();
        List<Location> startLocations = matchMakeRequest.getLobby()
                .getLobbyPlayers().stream()
                .map(lobbyPlayer -> lobbyPlayer.getUserSettings().getLocation())
                .collect(Collectors.toList());
//
//        List<Location> endLocations = courts.stream()
//                .map(court -> court.getLocation())
//                .collect(Collectors.toList());

        List<String> startLocationsAsString = startLocations.stream()
                .map(Location::getCoordinatesAsString)
                .collect(Collectors.toList());

//        List<String> endLocationsAsString = endLocations.stream()
//                .map(Location::getCoordinatesAsString)
//                .collect(Collectors.toList());

        //distanceFinder.distanceRequest();

        return null;

    }

}
