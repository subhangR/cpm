package com.playm8s.cpm.runners;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.playm8s.cpm.constants.MongoTablesEnum;
import com.playm8s.cpm.models.dtos.matchmaking.MatchMakeRequest;
import com.playm8s.cpm.models.entities.player.User;
import com.playm8s.cpm.repositories.MongoRepository;
import com.playm8s.cpm.util.DummyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;


@Service
public class TestRunner implements CommandLineRunner {

    @Autowired
    MongoRepository mongoRepository;

    @Override
    public void run(String... args) throws Exception {
       List<MatchMakeRequest> matchMakeRequestList =  mongoRepository.fetchAllActiveMatchRequests();
        String pathToServiceAccountFile = "/Users/subhang/Downloads/cpm/src/main/resources/playmates-app-firebase-adminsdk-f7jgy-90cd9358f7.json";

        FileInputStream serviceAccount = new FileInputStream(pathToServiceAccountFile);

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
       String registrationToken = "+dOwSE9TvS3OCQKBgMXcRWP:APA91bFXeSeVTsp3EF6tDskkD1UsfCcaoWvs_9afE-TWKw_Pt-t7WQwFki2NDCCaGPh-StUznEe8UAPf44T9X8gR3kd4VKyj3CMr2o9YSz950YUeDtr8hUF8HgAZDIa4FwoWpk74FxJa";
        Message message = Message.builder()
                .putData("score", "850")
                .putData("time", "2:45")
                .setToken(registrationToken)
                .build();
        String response = FirebaseMessaging.getInstance().send(message);


// Response is a message ID string.
        System.out.println("Successfully sent message: " + response);
        System.out.println(DummyUtil.gameModes());
        Map<String,User> userMap = DummyUtil.userMap();
        System.out.println(userMap);
        System.out.println(DummyUtil.userSettingsMap(userMap));
        System.out.println(DummyUtil.arenasMap());
       System.out.println(matchMakeRequestList);

       MatchMakeRequest mr =
               mongoRepository.fetchObject("991d8e6f-fe1f-4bd0-9f77-1aea56d31db3"
                       ,MongoTablesEnum.MATCH_REQUESTS,MatchMakeRequest.class);
        System.out.println(mr);
    }


}
