package com.masterclass.oldcontent.section10.challenge;

public class Main {

    public static void main(String[] args) {
        
        League<Team<FootballPlayer>> footballLeague = new League<>("Football League");

        Team<FootballPlayer> footballTeam = new Team<>("Football Team");
        footballTeam.addPlayer(new FootballPlayer("Player1"));
        footballTeam.addPlayer(new FootballPlayer("Player2"));
        footballTeam.addPlayer(new FootballPlayer("Player3"));
        footballTeam.addPlayer(new FootballPlayer("Player4"));
        footballTeam.addPlayer(new FootballPlayer("Player5"));

        Team<FootballPlayer> footballTeam2 = new Team<>("Football Team");
        footballTeam2.addPlayer(new FootballPlayer("Player1"));
        footballTeam2.addPlayer(new FootballPlayer("Player2"));
        footballTeam2.addPlayer(new FootballPlayer("Player3"));
        footballTeam2.addPlayer(new FootballPlayer("Player4"));
        footballTeam2.addPlayer(new FootballPlayer("Player5"));

        Team<FootballPlayer> footballTeam3 = new Team<>("Football Team");
        footballTeam3.addPlayer(new FootballPlayer("Player1"));
        footballTeam3.addPlayer(new FootballPlayer("Player2"));
        footballTeam3.addPlayer(new FootballPlayer("Player3"));
        footballTeam3.addPlayer(new FootballPlayer("Player4"));
        footballTeam3.addPlayer(new FootballPlayer("Player5"));

        footballLeague.addTeam(footballTeam);
        footballLeague.addTeam(footballTeam2);
        footballLeague.addTeam(footballTeam3);

        footballTeam.matchResult(footballTeam2, 2, 0);
        footballTeam.matchResult(footballTeam3, 0, 3);
        footballTeam2.matchResult(footballTeam, 2, 1);
        footballTeam2.matchResult(footballTeam3, 0, 0);
        footballTeam3.matchResult(footballTeam2, 0, 0);
        footballTeam3.matchResult(footballTeam, 0, 2);

        footballLeague.showRanking();


    
    }
}
