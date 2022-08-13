package com.playm8s.cpm.repositories;


import com.playm8s.cpm.models.entities.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player,String> {

}
