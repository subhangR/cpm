package com.playm8s.cpm.controllers;

import com.playm8s.cpm.models.entities.player.Player;
import com.playm8s.cpm.repositories.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/player")
public class PlayerController {
    @Autowired
    PlayerRepository playerRepository;
    Logger log = LoggerFactory.getLogger(PlayerController.class);

    /** Save Player to Postgres table.
     *
     * @param player
     * @return
     */
    @RequestMapping(value="/create",method= RequestMethod.POST)
    Player savePlayer(@RequestBody Player player) {
        try {
            playerRepository.save(player);
        } catch (Exception e) {
            log.error("event=ErrorSavingPlayer player={}",player);
            return null;
        }
        return player;
    }

    /** Fetch Player Details.
     *
     * @param playerId
     * @return
     */
    @RequestMapping(path="/{id}",method= RequestMethod.GET)
    Player getPlayer(@PathVariable("id") String  playerId) {
       Optional<Player> player =  playerRepository.findById(playerId);
       return player.orElse(null);
    }

    /** show All Players.
     *
     * @return
     */
    @RequestMapping(value="/all",method= RequestMethod.GET)
    String showAllPlayers() {
        String response = "";
        List<Player> players = playerRepository.findAll();
        for(Player player : players) {
            response += player.toString();
        }
        return response;
    }


}
