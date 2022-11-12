package com.maciej.wsbdataapi.service;

import com.maciej.wsbdataapi.model.SoccerPlayer;
import org.springframework.stereotype.Service;

@Service
public class WsbService {

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

}
