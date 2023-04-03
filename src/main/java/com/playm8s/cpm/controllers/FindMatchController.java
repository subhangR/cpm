package com.playm8s.cpm.controllers;


import com.playm8s.cpm.constants.MongoTablesEnum;
import com.playm8s.cpm.models.dtos.matchmaking.MatchMakeRequest;
import com.playm8s.cpm.repositories.MongoRepository;
import com.playm8s.cpm.util.DummyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/find")
public class FindMatchController {
    @Autowired
    MongoRepository mongoRepository;

    Logger log = LoggerFactory.getLogger(FindMatchController.class);

        @RequestMapping(value="/match",method= RequestMethod.POST)
    String findMatch(@RequestBody String matchMakeRequest) {
            System.out.println(matchMakeRequest);
        try {
            return mongoRepository.saveMatchMakeRequest(DummyUtil.getRandomMatchMakeRequest());
        } catch (Exception e) {
            log.error("event=ErrorSavingMatchMakeRequest request={}", matchMakeRequest);
            return "Failed";
        }
    }


    @RequestMapping(value="/match",method= RequestMethod.GET)
    MatchMakeRequest getMatchMakeRequestFromRequestIdFromMongo(@RequestParam String requestId) {
            try {
                return mongoRepository.fetchObject(requestId, MongoTablesEnum.MATCH_REQUESTS, MatchMakeRequest.class);
            } catch (Exception e) {
                log.error("event=ErrorFetchingMatchMakeRequest request={}", requestId);
                return null;
            }
    }

}
