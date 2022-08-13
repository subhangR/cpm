package com.playm8s.cpm.runners;


import com.playm8s.cpm.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TestRunner implements CommandLineRunner {


    @Autowired
    PlayerRepository playerRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}
