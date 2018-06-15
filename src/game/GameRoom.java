package game;

import builderteam.InvalidDataException;
import files.PropertiesConfig;
import java.util.ArrayList;
import objects.Padlock;
import objects.Team;
import objects.RoomRiddle;

/**
 *
 * @author Jermy
 */
public class GameRoom extends Thread {
    
    private Game game;
    private String currentRoom;
    private Team team;
    private ArrayList<Padlock> padlocks;
    private int unlock;
    private boolean update;
    private int loadInfo;

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public GameRoom(Game game, Team team, RoomRiddle gameRiddle) {
        this.game = game;
        this.team = team;
        this.unlock = 0;
        this.loadInfo = 0;
    }

    public String getCurrentRoom() {
        return this.currentRoom;
    }

    public void winner() throws InvalidDataException {
        if (unlock == PropertiesConfig.getInstance().getProperties("padlocksCount")) {
            throw new InvalidDataException("Ganó");
        }
        throw new InvalidDataException("Perdió");
    }

    public void tryUnlock(String msj) {
        if (padlocks.get(unlock).tryOpen(msj)) {
            unlock++;
            loadInfo = 0;
            if (unlock == PropertiesConfig.getInstance().getProperties("padlocksCount")) {
                game.setFinishGame(true);
                notifyAll();
            }
        }
    }

    public void openWindowSingle() {
        
    }

    private void openWindowsPlayTeam(int players) {
        for (int i = 0; i < players; i++) {
        }
    }

    public String updateWindow() {
        switch (unlock) {
        }
        return "";
    }
}
