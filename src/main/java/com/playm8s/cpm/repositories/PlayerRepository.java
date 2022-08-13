package com.playm8s.cpm.repositories;


import com.playm8s.cpm.models.entities.player.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player,String> {
}
