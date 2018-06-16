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
    private boolean singleGame;

    public boolean isSingleGame() {
        return singleGame;
    }

    public void setSingleGame(boolean singleGame) {
        this.singleGame = singleGame;
    }

    public GameRoom(Game game, Team team, RoomRiddle gameRiddle) {
        this.game = game;
        this.roomRiddle = gameRiddle;
        this.padlocks = new ArrayList();
        this.team = team;
        this.unlock = 0;
        this.singleGame = false;
        loadPadlocks();
    }

    public GameRoom(Game game, Team team, RoomRiddle gameRiddle, boolean singleGmae) {
        this.game = game;
        this.roomRiddle = gameRiddle;
        this.padlocks = new ArrayList();
        this.team = team;
        this.unlock = 0;
        this.singleGame = singleGame;
        loadPadlocks();
    }

    public void winner() throws InvalidDataException {
        if (unlock == PropertiesConfig.getInstance().getProperties("padlocksCount")) {
            if (singleGame) {
                team.setBestTimeSingle("");
            } else {
                team.setBestTimeMultiplayer("");
            }
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
}
