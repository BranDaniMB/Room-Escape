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
public class Game extends Thread {

    private boolean finishGame;
    private Chrono chrono;
    private ArrayList<Team> teamsPlaying;

    public Game(ArrayList<Team> teams) {
        this.finishGame = false;
        this.chrono = new Chrono();
        this.teamsPlaying = teams;
    }

    public Game() {
        this.finishGame = false;
        this.chrono = new Chrono();
        this.teamsPlaying = new ArrayList<>();
    }

    public void createGameRoom(Team team, runGameRiddle gameRiddle) {
        new GameRoom(this, team, gameRiddle).openWindowsPlayTeam();
    }

    public void createSingleGame(Team team, runGameRiddle gameRiddle) {
        for (int i = 0; i < team.getPlayersOnline(); i++) {
            new GameRoom(this, team, gameRiddle).openWindow();
        }
    }

    public Chrono getChrono() {
        return chrono;
    }

    public void setChrono(Chrono chrono) {
        this.chrono = chrono;
    }

    public boolean isFinishGame() {
        return finishGame;
    }

    public void setFinishGame(boolean finishGame) {
        this.finishGame = finishGame;
    }
}
