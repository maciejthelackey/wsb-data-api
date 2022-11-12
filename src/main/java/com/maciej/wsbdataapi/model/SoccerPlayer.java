package com.maciej.wsbdataapi.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SoccerPlayer {

    int goalsScored;
    boolean playingGame;
    String playerName;


}

