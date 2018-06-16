package game;

import java.util.ArrayList;
import listManager.ListRoomRiddle;
import objects.Team;
import objects.RoomRiddle;

/**
 *
 * @author Jermy
 */
public class Game extends Thread{

    private boolean finishGame;
    private ArrayList<Team> teamsPlaying;
    private ArrayList<RoomRiddle> roomRiddles;

    public Game(ArrayList<Team> teams) {
        this.finishGame = false;
        this.teamsPlaying = teams;
        this.roomRiddles = (ArrayList<RoomRiddle>) ListRoomRiddle.getInstance().getListRiddle().clone();
    }

    public Game() {
        this.finishGame = false;
        this.roomRiddles = (ArrayList<RoomRiddle>) ListRoomRiddle.getInstance().getListRiddle().clone();
    }

    private RoomRiddle generateRoom() {
        return roomRiddles.remove((int) (Math.random() * roomRiddles.size()));
    }

    public void creatMultiplayerGame() {
        for (int i = 0; i < teamsPlaying.size(); i++) {
            createGameRoom(teamsPlaying.get(i));
        }
    }

    private void createGameRoom(Team team) {
        new GameRoom(this, team, generateRoom()).openWindowsPlayTeam();
    }

    public void createSingleGame(Team team) {
        for (int i = 0; i < team.getPlayersOnline(); i++) {
            new GameRoom(this, team, generateRoom()).openWindowSingle();
        }
    }

    public boolean isFinishGame() {
        return finishGame;
    }

    public void setFinishGame(boolean finishGame) {
        this.finishGame = finishGame;
        notifyAll();
    }
    
    public ArrayList<Team> getTeamsPlaying() {
        return teamsPlaying;
    }

    public void setTeamsPlaying(ArrayList<Team> teamsPlaying) {
        this.teamsPlaying = teamsPlaying;
    }

}
