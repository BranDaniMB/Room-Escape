package game;

import objects.Riddle;
import files.PropertiesConfig;
import gui.rooms.InitRoomGui;
import java.util.ArrayList;
import objects.Padlock;
import objects.Team;

/**
 *
 * @author Jermy
 */
public class GameRoom extends Thread {

    private Game game;
    private String currentRoom = InitRoomGui.ROOM_3;
    private Team team;
    private ArrayList<Padlock> padlocks;
    private int unlock;
    private int players;
    private boolean update;

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public GameRoom(Game game, Team team, int players) {
        this.game = game;
        this.team = team;
        this.unlock = 0;
        this.players = players;
        openWindowsPlay();
    }

    public String getCurrentRoom() {
        return this.currentRoom;
    }

    public void winner() {
        if (unlock == PropertiesConfig.getInstance().getProperties("padlocksCount")) {
        }
    }

    public void tryUnlock(String msj) {
        if (padlocks.get(unlock).tryOpen(msj)) {
            unlock++;
            winner();
        }
    }

    private void openWindowsPlay() {
        for (int i = 0; i < players; i++) {
            
        }
    }
}
