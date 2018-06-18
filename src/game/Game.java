package game;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import listManager.ListRoomRiddle;
import objects.Player;
import objects.Team;
import objects.RoomRiddle;
import objects.Subteam;

/**
 *
 * @author Jermy
 */
public class Game extends Thread {

    private boolean finishGame;
    private final TreeMap<Team, Subteam> list;
    private ArrayList<RoomRiddle> roomRiddles;
    private ArrayList<GameRoom> currentGames;

    public Game(TreeMap<Team, Subteam> list) {
        this.currentGames = new ArrayList<>();
        this.finishGame = false;
        this.list = list;
        this.roomRiddles = (ArrayList<RoomRiddle>) ListRoomRiddle.getInstance().getListRiddle().clone();
    }

    private RoomRiddle generateRoom() {
        return roomRiddles.remove((int) (Math.random() * roomRiddles.size()));
    }

    public void createSingleGame() {
        Entry<Team, Subteam> entry = list.pollFirstEntry();
        Subteam st = entry.getValue();
        do {
            Player p = st.remove();
            if (p == null) {
                break;
            }
            this.currentGames.add(new GameRoom(this, entry.getKey(), p, generateRoom(), GameRoom.TYPE_GAME_SINGLE).openWindowsSingle());
        } while (true);
    }

    public void createMultiplayerGame() {
        do {
            Entry entry = list.pollFirstEntry();
            if (entry == null) {
                break;
            }
            this.currentGames.add(new GameRoom(this, entry, generateRoom(), GameRoom.TYPE_GAME_MULTIPLAYER).openWindowsMultiplayer());
        } while (true);
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

    public synchronized void setFinishGame(boolean finishGame) {
        this.finishGame = finishGame;
        closeAllGames();
    }

    public ArrayList<Team> getTeamsPlaying() {
        Set<Team> t = list.keySet();
        return new ArrayList<>(t);
    }

    public void closeAllGames() {
        for (int i = 0; i < currentGames.size(); i++) {
            currentGames.get(i).finshGameM();
        }
    }
}
