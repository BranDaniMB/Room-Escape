package game;

import builderteam.InvalidDataException;
import files.PropertiesConfig;
import java.util.ArrayList;
import objects.Padlock;
import objects.Team;
import objects.runGameRiddle;

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
    private int players;
    private boolean update;
    private int loadInfo;

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public GameRoom(Game game, Team team, runGameRiddle gameRiddle, int players) {
        this.game = game;
        this.team = team;
        this.unlock = 0;
        this.loadInfo = 0;
        this.players = players;
        openWindowsPlay();
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

    private void openWindowsPlay() {
        for (int i = 0; i < players; i++) {

        }
    }

    public String buttonInfo() {
        return padlocks.get(unlock).getRiddle().getTracks().get(loadInfo++);
    }

    public String updateWindow() {
        switch (unlock) {
            case 0:
                return "padlock1-objectButton1-objectButton2-objectButton3";
            case 1:
                return "padlock2-objectButton4-objectButton5-objectButton6";
            case 2:
                return "padlock3-objectButton7-objectButton8-objectButton9";
            case 3:
                return "padlock4-objectButton10-objectButton11-objectButton12";
        }
        return "";
    }
}
