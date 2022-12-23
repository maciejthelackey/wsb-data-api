package com.maciej.wsbdataapi.client;

import com.maciej.wsbdataapi.model.WsbResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Component
public class WsbClient {
    public List<WsbResponse> retrieveData(String date){

        WebClient client = WebClient.create("https://tradestie.com/api/v1/apps");

        WsbResponse[] response = client.get()
                .uri("/reddit")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(WsbResponse[].class)
                .block();

        List<WsbResponse> listResponse = Arrays.asList(response);
        return listResponse;

    }
}
