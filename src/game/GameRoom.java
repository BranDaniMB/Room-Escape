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

    public static final String TYPE_GAME_SINGLE = "single";
    public static final String TYPE_GAME_MULTIPLAYER = "multiplayer";

    private Game game;
    private RoomRiddle roomRiddle;
    private Team team;
    private ArrayList<Padlock> padlocks;
    private int unlock;
    private String type;

    public boolean isSingleGame() {
        return type.equals("single");
    }

    public GameRoom(Game game, Team team, RoomRiddle gameRiddle, String type) {
        this.game = game;
        this.roomRiddle = gameRiddle;
        this.padlocks = new ArrayList();
        this.team = team;
        this.unlock = 0;
        this.type = type;
        loadPadlocks();
    }

    /**
     * @deprecated not necessary
     */
    public void winner() throws InvalidDataException {
        if (unlock == PropertiesConfig.getInstance().getProperties("padlocksCount")) {
            if (type.equals(TYPE_GAME_SINGLE)) {
                team.setBestTimeSingle("");
            } else {
                team.setBestTimeMultiplayer("");
            }
            throw new InvalidDataException("Ganó");
        } else {
            throw new InvalidDataException("Perdió");
        }
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
            padlocks.add(new Padlock(roomRiddle.getListRiddle().get(i), "Candado: " + i));
        }
    }

    public void openWindowSingle() {
    }

    public void openWindowsMultiplayer(int players) {
        for (int i = 0; i < players; i++) {

        }
    }
}
