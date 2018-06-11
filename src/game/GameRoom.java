/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import Objects.Riddle;
import files.PropertiesConfig;
import gui.rooms.ManagerGameWindows;
import java.util.ArrayList;

/**
 *
 * @author Jermy
 */
public class GameRoom extends Thread {

    private ArrayList<Boolean> padlocksOpen;
    private ArrayList<Riddle> riddles;
    private Game game;
    private String currentRoom = ManagerGameWindows.ROOM_3;

    public GameRoom(Game game) {
        this.padlocksOpen = new ArrayList<>();
        this.riddles = new ArrayList<>();
        this.game = game;
    }

    public ArrayList<Boolean> getPadlocksOpen() {
        return padlocksOpen;
    }

    public void setPadlocksOpen(ArrayList<Boolean> padlocksOpen) {
        this.padlocksOpen = padlocksOpen;
    }

    public ArrayList<Riddle> getRiddles() {
        return riddles;
    }

    public void setRiddles(ArrayList<Riddle> riddles) {
        this.riddles = riddles;
    }

    private void winnner() {
        int count = 0;
        for (int i = 0; i < PropertiesConfig.getInstance().getProperties("padlocksCount"); i++) {
            count = (padlocksOpen.get(i) == true) ? count++ : count;
        }
        if (count == padlocksOpen.size()) {
            game.setFinishGame(true);
        }
    }

    public boolean tryOpen(String msg) {
        for (int i = 0; i < riddles.size(); i++) {
            if (riddles.get(i).isCorrect(msg)) {
                padlocksOpen.set(i, true);
                winnner();
                return true;
            }
        }
        return false;
    }

    public String getCurrentRoom() {
        return this.currentRoom;
    }
}
