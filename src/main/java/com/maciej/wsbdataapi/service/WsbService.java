package com.maciej.wsbdataapi.service;

import com.maciej.wsbdataapi.client.WsbClient;
import com.maciej.wsbdataapi.model.SoccerPlayer;
import com.maciej.wsbdataapi.model.WsbResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WsbService {

    @Autowired
    WsbClient client;


    public int add10(int inputNumber) {
        return inputNumber + 10;
    }

    public SoccerPlayer constructSoccerPlayer(int goalScored, boolean playingGame, String playerName) {

        SoccerPlayer tempSoccerPlayer = SoccerPlayer.builder()
                .goalsScored(goalScored)
                .playingGame(playingGame)
                .playerName(playerName)
                .build();

        return tempSoccerPlayer;
    }


    public List<WsbResponse> callWsbData(String date) {

        return client.retrieveData(date);

    }

    public List<WsbResponse> callWsbDataticker(String ticker,String date){


        return client.retrieveTickerData(ticker,date);
    }

}
