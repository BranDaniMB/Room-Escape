/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import listManager.ListRoomRiddle;
import objects.Team;
import objects.RoomRiddle;

/**
 *
 * @author Jermy
 */
public class Game extends Thread {

    private boolean finishGame;
    private Chrono chrono;
    private ArrayList<Team> teamsPlaying;
    private ArrayList<RoomRiddle> roomRiddles;

    public Game(ArrayList<Team> teams) {
        this.finishGame = false;
        this.chrono = new Chrono();
        this.teamsPlaying = teams;
        this.roomRiddles = (ArrayList<RoomRiddle>) ListRoomRiddle.getInstance().getListRiddle().clone();
    }

    public Game() {
        this.finishGame = false;
        this.chrono = new Chrono();
        this.teamsPlaying = new ArrayList<>();
    }

    public RoomRiddle generateRoom() {
        return roomRiddles.remove((int) (Math.random() * roomRiddles.size()));
    }

    public void creatMultiplayerGame() {
        for (int i = 0; i < teamsPlaying.size(); i++) {
            createGameRoom(teamsPlaying.get(i));
        }
    }

    private void createGameRoom(Team team) {
        new GameRoom(this, team, generateRoom());
    }

    public void createSingleGame(Team team) {
        for (int i = 0; i < team.getPlayersOnline(); i++) {
            new GameRoom(this, team, generateRoom());
        }
    }

    public boolean isFinishGame() {
        return finishGame;
    }

    public void setFinishGame(boolean finishGame) {
        this.finishGame = finishGame;
    }

    public Chrono getChrono() {
        return chrono;
    }

    public void setChrono(Chrono chrono) {
        this.chrono = chrono;
    }

    public ArrayList<Team> getTeamsPlaying() {
        return teamsPlaying;
    }

    public void setTeamsPlaying(ArrayList<Team> teamsPlaying) {
        this.teamsPlaying = teamsPlaying;
    }

}
