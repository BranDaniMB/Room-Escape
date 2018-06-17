/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;

/**
 *
 * @author Jermy
 */
public class Subteam {
    
    private ArrayList<Player> players;
    
    public Subteam() {
        this.players = new ArrayList<>();
    }

    public int size() {
        return players.size();
    }
    
    public Player get(int index) {
        return players.get(index);
    }
    
    public boolean add(Player e) {
        return players.add(e);
    }
    
    public Player remove(int index) {
        return players.remove(index);
    }
    
    public ArrayList<Player> getPlayers() {
        return players;
    }
    
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void finisPlayerOff() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setSelected(false);
        }
    }
    
    public void isPlaying() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setSelected(true);
        }
    }
}
