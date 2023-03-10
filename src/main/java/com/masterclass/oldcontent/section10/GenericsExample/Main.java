package com.masterclass.oldcontent.section10.GenericsExample;

public class Main {

    public static void main(String[] args) {

        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> footballTime = new Team<FootballPlayer>("Adelaide Crows");
        footballTime.addPlayer(joe);

        Team<BaseballPlayer> baseballTime = new Team<BaseballPlayer>("Chicago Cubs");
        baseballTime.addPlayer(pat);

        Team<SoccerPlayer> soccerTime = new Team<SoccerPlayer>("Barcelona");
        soccerTime.addPlayer(beckham);

        
        
    }
    
}
