package com.masterclass.oldcontent.section10.challenge;

import java.util.ArrayList;
import java.util.Collections;

public class League <T extends Team<?>> {

    private String LeagueName;
    private ArrayList<T> teams;

    public League(String leagueName) {
        this.LeagueName = leagueName;
        this.teams = new ArrayList<T>();
        
    }

    public String getLeagueName() {
        return LeagueName;
    }

    public ArrayList<T> getTeams() {
        return teams;
    }

    public boolean addTeam(T team) {
        if (this.teams.contains(team)) {
            return false;
        } else {
            this.teams.add(team);
            return true;
        }
    }

    public void showRanking(){
        Collections.sort(this.teams);

        for (T team : teams) {
            System.out.println(team);
        }
        
    }
    
}
