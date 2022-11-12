package com.maciej.wsbdataapi.controller;

import com.maciej.wsbdataapi.model.SoccerPlayer;
import com.maciej.wsbdataapi.service.WsbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WsbController {

    @Autowired
    WsbService wsbService;

    @GetMapping("/hello")
    public String hello(@RequestParam String name){
        return "Hello " + name;
    }

    @PostMapping("/addTen")
    public int addten(@RequestParam int input){
        return wsbService.add10(10);
    }

    @PostMapping("/soccerPlayer")
    public SoccerPlayer constructSoccerPlayer(@RequestParam int goalScored, @RequestParam boolean playingGame, @RequestParam String playerName){
        return wsbService.constructSoccerPlayer(goalScored,playingGame, playerName);
    }



}
