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
    private RoomRiddle roomRiddle;
    private Team team;
    private ArrayList<Padlock> padlocks;
    private int unlock;
    private boolean update;

    public GameRoom() {
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public GameRoom(Game game, Team team, RoomRiddle gameRiddle) {
        this.game = game;
        this.roomRiddle = gameRiddle;
        this.team = team;
        this.unlock = 0;
        loadPadlocks();
    }

    public void winner() throws InvalidDataException {
        if (unlock == PropertiesConfig.getInstance().getProperties("padlocksCount")) {
            throw new InvalidDataException("Ganó");
        }
        throw new InvalidDataException("Perdió");
    }

    public void tryUnlock(String msj) {
        for (int i = 0; i < padlocks.size(); i++) {
            if (padlocks.get(i).tryOpen(msj)) {
                unlock++;
                if (unlock == PropertiesConfig.getInstance().getProperties("padlocksCount")) {
                    game.setFinishGame(true);
                    notifyAll();
                }
            }
        }
    }

    private void loadPadlocks() {
        for (int i = 0; i < roomRiddle.getListRiddle().size(); i++) {
            padlocks.add(new Padlock(roomRiddle.getListRiddle().get(i)));
        }
    }

    public void openWindowSingle() {
    }

    public void openWindowsPlayTeam(int players) {
        for (int i = 0; i < players; i++) {
            
        }
    }

    public String updateWindow() {
        switch (unlock) {
        }
        return "";
    }
}
