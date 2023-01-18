package com.maciej.wsbdataapi.controller;

import com.maciej.wsbdataapi.model.SoccerPlayer;
import com.maciej.wsbdataapi.model.WsbResponse;
import com.maciej.wsbdataapi.service.WsbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WsbController {

    @Autowired
    WsbService wsbService;

    @GetMapping("/health")
    public String health(@RequestParam String name){
        return "UP";
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/wsbData")
    public List<WsbResponse> callWsbData(@RequestParam String date){
        return wsbService.callWsbData(date);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/wsbData/specific")
    public List<WsbResponse> callWsbDataTicker(@RequestParam List<String> tickers, @RequestParam String date){
        return wsbService.callWsbDataticker(tickers,date);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/wsbData/score")
    public List<WsbResponse> callSentimentScore(@RequestParam String date){
        return wsbService.callSentimentScore(date);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/wsbData/negative")
    public List<WsbResponse> callNegitiveScore(@RequestParam String date){
        return wsbService.callNegitiveScore(date);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("wsbData/negativeComments")
    public List<WsbResponse> callNegativeWithComments(@RequestParam String date){
        return wsbService.callNegativeWithComments(date);
    }
}
