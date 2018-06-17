package game;

import java.util.ArrayList;
import java.util.Map;
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

    public Game(TreeMap<Team, Subteam> list) {
        this.finishGame = false;
        this.list = list;
        this.roomRiddles = (ArrayList<RoomRiddle>) ListRoomRiddle.getInstance().getListRiddle().clone();
    }

    private RoomRiddle generateRoom() {
        return roomRiddles.remove((int) (Math.random() * roomRiddles.size()));
    }
    
    public void createSingleGame() {
        Entry<Team, Subteam> entry = list.pollFirstEntry();
        System.out.println(entry.getValue().size());
        
        Subteam st = entry.getValue();
        do {
            Player p = st.remove();
            if (p == null) {
                break;
            }
            new GameRoom(this, entry.getKey(), p, generateRoom(), GameRoom.TYPE_GAME_SINGLE).openWindowsSingle();
            System.out.println(p);
        } while(true);
    }

    public void createMultiplayerGame() {
        do {
            Entry entry = list.pollFirstEntry();
            if (entry == null) {
                break;
            }
            new GameRoom(this, entry, generateRoom(), GameRoom.TYPE_GAME_MULTIPLAYER).openWindowsMultiplayer();
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
    }

    public ArrayList<Team> getTeamsPlaying() {
        Set<Team> t = list.keySet();
        return new ArrayList<>(t);
    }
}
