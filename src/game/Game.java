package game;

import java.util.ArrayList;
import listManager.ListRoomRiddle;
import objects.Team;
import objects.RoomRiddle;
import objects.Subteam;

/**
 *
 * @author Jermy
 */
public class Game extends Thread {

    private boolean finishGame;
    private ArrayList<Team> teamsPlaying;
    private ArrayList<Subteam> subteams;
    private ArrayList<RoomRiddle> roomRiddles;
    public Game(ArrayList<Team> teams, ArrayList<Subteam> subteams) {
        this.finishGame = false;
        this.teamsPlaying = teams;
        this.subteams = subteams;
        this.roomRiddles = (ArrayList<RoomRiddle>) ListRoomRiddle.getInstance().getListRiddle().clone();
    }

    public Game() {
        this.finishGame = false;
        this.roomRiddles = (ArrayList<RoomRiddle>) ListRoomRiddle.getInstance().getListRiddle().clone();
    }

    private RoomRiddle generateRoom() {
        return roomRiddles.remove((int) (Math.random() * roomRiddles.size()));
    }

    public void createMultiplayerGame() {
        for (int i = 0; i < teamsPlaying.size(); i++) {
            createGameRoom(teamsPlaying.get(i), subteams.get(i).size(), GameRoom.TYPE_GAME_MULTIPLAYER);
        }
    }

    private void createGameRoom(Team team, int players, String type) {
        new GameRoom(this, team, generateRoom(), type).openWindowsMultiplayer(players);
    }

    public void createSingleGame(Team team, int players) {
        for (int i = 0; i < players; i++) {
            new GameRoom(this, team, generateRoom(), GameRoom.TYPE_GAME_SINGLE).openWindowSingle();
        }
    }

    public boolean isFinishGame() {
        return finishGame;
    }

    public ArrayList<RoomRiddle> getRoomRiddles() {
        return roomRiddles;
    }

    public void setRoomRiddles(ArrayList<RoomRiddle> roomRiddles) {
        this.roomRiddles = roomRiddles;
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

    public void gameFinishTeamsOff() {
        for (int i = 0; i < teamsPlaying.size(); i++) {
            teamsPlaying.get(i).setPlaying(false);
            subteams.get(i).finisPlayerOff();
        }
    }
}
