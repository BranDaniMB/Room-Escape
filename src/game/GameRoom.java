package game;

import builderteam.InvalidDataException;
import files.PropertiesConfig;
import gui.rooms.RoomInterface;
import java.util.ArrayList;
import objects.Padlock;
import objects.Team;
import objects.RoomRiddle;

/**
 *
 * @author Jermy
 */
public class GameRoom extends Thread implements Observer {

    public static final String TYPE_GAME_SINGLE = "single";
    public static final String TYPE_GAME_MULTIPLAYER = "multiplayer";

    private Game game;
    private Team team;
    private ArrayList<Padlock> padlocks;
    private ArrayList<RoomInterface> rooms;
    private int unlock;
    private String type;
    private RoomInterface room;

    public boolean isSingleGame() {
        return type.equals("single");
    }

    public GameRoom(Game game, Team team, RoomRiddle gameRiddle, String type) {
        this.game = game;
        this.padlocks = new ArrayList();
        this.team = team;
        this.unlock = 0;
        this.type = type;
        this.room = gameRiddle.getRoomInterface();
        loadPadlocks(gameRiddle);
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

    public void tryUnlockPadlock(String msj, int padlock) {
        if (padlocks.get(padlock).tryOpen((msj.toLowerCase().trim()))) {
            unlock++;
            update(padlocks.get(padlock).getIdPadlock() + " desbloqueado+\n");
            if (unlock == PropertiesConfig.getInstance().getProperties("padlocksCount")) {
                game.setFinishGame(true);
                notifyAll();
            }
        }
    }

    public void tryUnlockTrack(String msj, int padlock) {
        if (padlocks.get(padlock).getRiddle().getTrackLock().tryUnlock(msj.toLowerCase().trim())) {
            update(padlocks.get(padlock).getIdPadlock() + " pista desbloqueada+\n");
        }
    }

    public String getPadlockQuestion(int padlock) {
        return padlocks.get(padlock).getRiddle().getQuestion();
    }

    public String getTrackSimple(int padlock, int track) {
        return padlocks.get(padlock).getRiddle().getTracks().get(track);
    }

    public String getLockedTrack(int padlock) {
        return padlocks.get(padlock).getRiddle().getTrackLock().getTrack();
    }

    private void loadPadlocks(RoomRiddle roomRiddle) {
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

    public boolean add(RoomInterface e) {
        return rooms.add(e);
    }

    public RoomInterface remove(int index) {
        return rooms.remove(index);
    }

    public void update(String msj) {
        for (int i = 0; i < rooms.size(); i++) {
            rooms.get(i).update(msj);
        }
    }

    @Override
    public void update() {
        for (int i = 0; i < rooms.size(); i++) {
            rooms.get(i);
        }
    }
}
