/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listManager;

import java.sql.Time;
import java.util.Date;
import java.util.TreeSet;

/**
 *
 * @author Jermy
 */
public class Team implements Comparable<Team> {

    private String teamName;
    private TreeSet<Player> playersList;
    private Date dateInscription;
    private Time bestTimeSingle;
    private Time bestTimeMultiplayer;
    private int playersOnline;
    private boolean playing;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public TreeSet<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(TreeSet<Player> playersList) {
        this.playersList = playersList;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Time getBestTimeSingle() {
        return bestTimeSingle;
    }

    public void setBestTimeSingle(Time bestTimeSingle) {
        this.bestTimeSingle = bestTimeSingle;
    }

    public Time getBestTimeMultiplayer() {
        return bestTimeMultiplayer;
    }

    public void setBestTimeMultiplayer(Time bestTimeMultiplayer) {
        this.bestTimeMultiplayer = bestTimeMultiplayer;
    }

    public int getPlayersOnline() {
        return playersOnline;
    }

    public void setPlayersOnline(int playersOnline) {
        this.playersOnline = playersOnline;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public int size() {
        return playersList.size();
    }

    public boolean add(Player e) {
        return playersList.add(e);
    }
    
    @Override
    public int compareTo(Team o) {
        return teamName.compareTo(o.teamName);
    }
    
}
