/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import objects.Team;
import objects.runGameRiddle;

/**
 *
 * @author Jermy
 */
public class Game extends Thread{
    private boolean finishGame;
    private ArrayList<GameRoom> gameRooms;
    private Chrono chrono;

    public void createGameRoom(Team team, runGameRiddle gameRiddle, int players) {
        GameRoom gameRoom = new GameRoom(this, team, gameRiddle, players);
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
