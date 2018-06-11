/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import objects.Team;

/**
 *
 * @author Jermy
 */
public class Game extends Thread {

    private Chrono chrono;
    private ArrayList<GameRoom> gameRooms;
    private boolean finishGame;

    public synchronized void singularMode() throws InterruptedException {
        Team 
                
        while (true) {
            wait();
        }
        
    }

    public synchronized void multiplayerMode() throws InterruptedException {
        while (true) {
            wait();
        }

    }

    public void starPlay() {
    }

    public void createGameRoom() {
        GameRoom gameRoom = new GameRoom(this);
        gameRooms.add(gameRoom);
        gameRoom.start();
    }
    
    public Chrono getChrono() {
        return chrono;
    }

    public void setChrono(Chrono chrono) {
        this.chrono = chrono;
    }

    public ArrayList<GameRoom> getGameRooms() {
        return gameRooms;
    }

    public void setGameRooms(ArrayList<GameRoom> gameRooms) {
        this.gameRooms = gameRooms;
    }

    public boolean isFinishGame() {
        return finishGame;
    }

    public void setFinishGame(boolean finishGame) {
        this.finishGame = finishGame;
    }

}
