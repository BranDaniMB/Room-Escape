package game;

import java.util.ArrayList;
import java.util.Iterator;
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

    public void createMultiplayerGame() {
        ArrayList<Team> teams = setIsPlayingTeams(new ArrayList<>(list.keySet()));
        ArrayList<Subteam> subteams = setIsPlayingPlayers(new ArrayList<>(list.values()));
        
        for (int i = 0; i < teams.size(); i++) {
            new GameRoom(this, teams.get(i), generateRoom(), GameRoom.TYPE_GAME_MULTIPLAYER).openWindowsMultiplayer(subteams.get(i).size());
        }
    }

    public void createSingleGame() {
        Map.Entry<Team, Subteam> entry = list.pollFirstEntry();
        entry.getKey().setSelect(true);

        Iterator<Player> iterator = entry.getValue().getPlayers().iterator();

        while (iterator.hasNext()) {
            iterator.next().setSelected(true);
        }
        
        for (int i = 0; i < entry.getValue().size(); i++) {
            new GameRoom(this, entry.getKey(), generateRoom(), GameRoom.TYPE_GAME_SINGLE).openWindowsSingle();
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

    public synchronized void setFinishGame(boolean finishGame) {
        this.finishGame = finishGame;
    }

    public ArrayList<Team> getTeamsPlaying() {
        Set<Team> t = list.keySet();
        return new ArrayList<>(t);
    }
    
    public ArrayList<Team> setIsPlayingTeams(ArrayList<Team> list) {
        list.forEach((e) -> {
            e.setSelect(true);
        });
        
        return list;
    }
    
    public ArrayList<Subteam> setIsPlayingPlayers(ArrayList<Subteam> list) {
        list.forEach((e) -> {
            e.isPlaying();
        });
        
        return list;
    }

    public void gameFinishTeamsOff() {
        Entry<Team,Subteam> t;
        
        do {
            t = list.pollFirstEntry();
            t.getKey().setSelect(false);
            t.getValue().finisPlayerOff();
        } while (true);
    }
}
