package com.playm8s.cpm.services;

import okhttp3.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DistanceFinder implements CommandLineRunner {

    private final String API_KEY= "AIzaSyAyi-y5KVzrElZ1ebk8IZdGrYpKoez6Deo";

    public Response distanceRequest(String origin, String destination) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        String url ="https://maps.googleapis.com/maps/api/distancematrix/json?origins="+origin+"&destinations="+destination+"&key="+ API_KEY;;
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return  response;

    }
    @Override
    public void run(String... args) throws Exception {
        String source = "17.42426,78.34769";
        String destination = "17.46183,78.36218";
        String source1 = "SRI SM BADMINTON COURT|PULSE 7 Kondapur|Spardha Badminton Academy";
        String dest2 = "Golf Edge Hyderabad";
        Response response = distanceRequest(source1,dest2);
        System.out.println(response.body().string());
    }
}
