package com.maciej.wsbdataapi.service;

import com.maciej.wsbdataapi.client.WsbClient;
import com.maciej.wsbdataapi.model.SoccerPlayer;
import com.maciej.wsbdataapi.model.WsbResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WsbService {

    @Autowired
    WsbClient client;

    public List<WsbResponse> callWsbData(String date) {

        return client.retrieveData(date);
    }

    public List<WsbResponse> callWsbDataticker(List<String> tickers,String date){

        List<String> upperCaseTickers = tickers.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        return client.retrieveData(date)
                .stream()
                .filter(stock -> upperCaseTickers.contains(stock.getTicker()))
                .collect(Collectors.toList());
    }

    //TODO return only postivie sentiment tickers



    // Commands to push to git hub branch
    // git status | Shows what files have been added your commit
    // git add . | Adds files to your commit
    // git commit -m "PUT MESSAGE IN HERE | commits the files you added
    // git push (Just copy and paste command it gives you to run) | Note: This will error and give you a new command, copy and paste and use that. This pushes your changes to github

    // git checkout -b "feature/ADD-YOU-NAME-HERE" | Creates branch, MAKE SURE YOU RUN THIS ONLY ON MAIN
}
