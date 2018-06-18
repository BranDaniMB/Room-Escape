/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.LinkedList;

/**
 *
 * @author Jermy
 */
public class Subteam {
    
    private LinkedList<Player> players;
    
    public Subteam() {
        this.players = new LinkedList<>();
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
    
    public Player remove() {
        return players.poll();
    }
    
    public LinkedList<Player> getPlayers() {
        return players;
    }
    
    public void setPlayers(LinkedList<Player> players) {
        this.players = players;
    }

    public void finishPlayerOff() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setSelected(false);
        }
    }
    
    public void makePlaying() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setSelected(true);
        }
    }
}
