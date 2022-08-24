package com.playm8s.cpm.services;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class DistanceFinder implements CommandLineRunner {


    @Value("${google.maps.apikey}")
    private  String API_KEY;

    public Response distanceMatrixRequest(List<String> origins, List<String> destinations) throws IOException {

        String originString = getCombinedLocationsString(origins);
        String destinationString = getCombinedLocationsString(destinations);
        Response response = distanceRequest(originString,destinationString);
        return response;
    }

    public Response distanceRequest(String originString, String destinationString) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        String url ="https://maps.googleapis.com/maps/api/distancematrix/json?origins="
                +originString+"&destinations="+destinationString+"&key="+ API_KEY;

        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url(url)
                .build();
        return client.newCall(request).execute();

    }
    @Override
    public void run(String... args) throws Exception {
        String source = "17.42426,78.34769";
        String destination = "17.405582400198824, 78.38867995939377";
        String source1 = "SRI SM BADMINTON COURT|PULSE 7 Kondapur|Spardha Badminton Academy";
        String dest2 = "Golf Edge Hyderabad";
        Response response = distanceRequest(source,destination);
        System.out.println(Objects.requireNonNull(response.body()).string());
    }

    private String getCombinedLocationsString(List<String> locations) {
        String combinedString = "";
        for(int i = 0;i < locations.size();i++) {
            combinedString += locations.get(i);
            if(i != locations.size()-1) {
                combinedString += "|";
            }
        }
        return combinedString;
    }
}
