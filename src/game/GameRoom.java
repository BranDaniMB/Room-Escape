package game;

import files.PropertiesConfig;
import gui.rooms.Room1;
import gui.rooms.Room2;
import gui.rooms.Room3;
import gui.rooms.Room4;
import gui.rooms.Room5;
import gui.rooms.Room6;
import gui.rooms.RoomsInterface;
import java.util.ArrayList;
import java.util.Map.Entry;
import objects.Padlock;
import objects.Player;
import objects.RoomRiddle;
import objects.Subteam;
import objects.Team;

/**
 *
 * @author Jermy
 */
public class GameRoom extends Thread implements Subject {

    public static final String TYPE_GAME_SINGLE = "single";
    public static final String TYPE_GAME_MULTIPLAYER = "multiplayer";

    private Game game;
    private Team team;
    private ArrayList<Padlock> padlocks;
    private ArrayList<RoomsInterface> roomsObserver;
    private int unlock;
    private String type;
    private Player player;
    private Subteam subteam;
    private RoomsInterface room;
    private boolean won;

    /**
     * Create a GameRoom for an individual game
     *
     * @param game
     * @param entry
     * @param gameRiddle
     * @param type
     */
    public GameRoom(Game game, Entry<Team, Subteam> entry, RoomRiddle gameRiddle, String type) {
        this.game = game;
        this.padlocks = new ArrayList<>();
        this.team = entry.getKey();
        this.unlock = 0;
        this.roomsObserver = new ArrayList<>();
        this.type = type;
        this.player = null;
        this.won = false;
        this.subteam = entry.getValue();
        this.subteam.makePlaying();
        this.room = gameRiddle.getRoom();
        loadPadlocks(gameRiddle);
    }

    /**
     * Create a GameRoom for an multiplayer game
     *
     * @param game
     * @param team
     * @param player
     * @param gameRiddle
     * @param type
     */
    public GameRoom(Game game, Team team, Player player, RoomRiddle gameRiddle, String type) {
        this.game = game;
        this.padlocks = new ArrayList<>();
        this.team = team;
        this.unlock = 0;
        this.won = false;
        this.roomsObserver = new ArrayList<>();
        this.type = type;
        this.player = player;
        this.player.setSelected(true);
        this.subteam = null;
        this.room = gameRiddle.getRoom();
        loadPadlocks(gameRiddle);
    }

    /**
     * Try to open a padlock, check if the game has been won.
     *
     * @param msj
     * @param padlock
     */
    public void tryUnlockPadlock(String msj, int padlock) {
        if (padlocks.get(padlock).tryOpen((msj.toLowerCase().trim()))) {
            unlock++;
            updateInfo(padlocks.get(padlock).getIdPadlock() + " desbloqueado\n");
            updatePadlock(padlock);
            setPadlockText(padlock);
            if (unlock == PropertiesConfig.getInstance().getProperties("padlocksCount")) {
                verifyWinner();
            }
        }
    }

    /**
     * Try to open a hint, if the answer is correct, open it.
     *
     * @param msj
     * @param padlock
     */
    public void tryUnlockTrack(String msj, int padlock) {
        if (padlocks.get(padlock).getRiddle().getTrackLock().tryUnlock((msj.toLowerCase().trim()))) {
            updateInfo(padlocks.get(padlock).getIdPadlock() + " pista desbloqueada\n");
            updateTracks(padlock);
        }
    }

    /**
     * Get the question linked to a padlock
     *
     * @param padlock
     * @return Question linked to the padlock
     */
    public String getPadlockQuestion(int padlock) {
        return padlocks.get(padlock).getRiddle().getQuestion();
    }

    /**
     * Get the question linked to a track
     *
     * @param padlock
     * @return Question linked to the track
     */
    public String getLockedTrackQuestion(int padlock) {
        return padlocks.get(padlock).getRiddle().getTrackLock().getQuestion();
    }

    /**
     * Get the track linked to a button
     *
     * @param padlock
     * @param track
     * @return Track linked to button
     */
    public String getTrackSimple(int padlock, int track) {
        return padlocks.get(padlock).getRiddle().getTracks().get(track);
    }

    /**
     *
     *
     * @param padlock
     * @return
     */
    public String getUnlockTrack(int padlock) {
        return padlocks.get(padlock).getRiddle().getTrackLock().getTrack();
    }

    /**
     *
     * @param roomRiddle
     */
    private void loadPadlocks(RoomRiddle roomRiddle) {
        for (int i = 0; i < roomRiddle.getListRiddle().size(); i++) {
            padlocks.add(new Padlock(roomRiddle.getListRiddle().get(i), "Candado: " + (i + 1)));
        }
    }

    /**
     *
     * @param padlock
     */
    private void setPadlockText(int padlock) {
        if (padlocks.get(padlock).isOpen()) {
            padlocks.get(padlock).getRiddle().getTrackLock().setTrack(padlocks.get(padlock).getRiddle().getTrackLock().getTrack() + "\n" + padlocks.get(padlock).getIdPadlock());
            for (int j = 0; j < padlocks.get(padlock).getRiddle().getTracks().size(); j++) {
                padlocks.get(padlock).getRiddle().getTracks().set(j, padlocks.get(padlock).getRiddle().getTracks().get(j) + "\n" + padlocks.get(padlock).getIdPadlock());
            }
        }
    }

    /**
     * Start individual game screens
     *
     * @return current GameRoom
     */
    public GameRoom openWindowsSingle() {
        createWindows(player.getId());
        return this;
    }

    /**
     * Create a game screen
     *
     * @param playerId
     */
    private void createWindows(String playerId) {
        if (room instanceof Room1) {
            Room1 room1 = new Room1(this, team.getTeamName() + " - " + playerId);
            addObserver(room1);
            room1.setVisible(true);
        } else if (room instanceof Room2) {
            Room2 room2 = new Room2(this, team.getTeamName() + " - " + playerId);
            addObserver(room2);
            room2.setVisible(true);
        } else if (room instanceof Room3) {
            Room3 room3 = new Room3(this, team.getTeamName() + " - " + playerId);
            addObserver(room3);
            room3.setVisible(true);
        } else if (room instanceof Room4) {
            Room4 room4 = new Room4(this, team.getTeamName() + " - " + playerId);
            addObserver(room4);
            room4.setVisible(true);
        } else if (room instanceof Room5) {
            Room5 room5 = new Room5(this, team.getTeamName() + " - " + playerId);
            addObserver(room5);
            room5.setVisible(true);
        } else if (room instanceof Room6) {
            Room6 room6 = new Room6(this, team.getTeamName() + " - " + playerId);
            addObserver(room6);
            room6.setVisible(true);
        }
    }

    /**
     * Start multiplayer game screens
     *
     * @return current GameRoom
     */
    public synchronized GameRoom openWindowsMultiplayer() {
        for (int i = 0; i < subteam.size(); i++) {
            createWindows(subteam.get(i).getId());
        }
        return this;
    }

    /**
     *
     *
     * @param msj
     */
    public synchronized void updateInfo(String msj) {
        for (int i = 0; i < roomsObserver.size(); i++) {
            roomsObserver.get(i).update(msj);
        }
    }

    /**
     *
     * @param padlock
     */
    public synchronized void updateTracks(int padlock) {
        for (int i = 0; i < roomsObserver.size(); i++) {
            roomsObserver.get(i).unlockTrackLocked(padlock);
        }
    }

    /**
     *
     * @param padlock
     */
    public synchronized void updatePadlock(int padlock) {
        for (int i = 0; i < roomsObserver.size(); i++) {
            roomsObserver.get(i).updatePadlock(padlock);
        }
    }

    /**
     *
     */
    public synchronized void verifyWinner() {
        if (!game.isFinishGame()) {
            won = true;
            game.setFinishGame(true);
        }
    }

    /**
     * Get game mode
     *
     * @return game mode
     */
    public String getType() {
        return type;
    }

    /**
     * @see deselect
     */
    public void finshGameM() {
        String txt = "";
        if (this.type.equals(TYPE_GAME_SINGLE)) {
            team.setBestTimeSingle(roomsObserver.get(0).getTime());
            deselect();
            if (won) {
                txt = "Ganó: Jugador " + player.getId();
            } else {
                txt = "Perdió: Jugador " + player.getId();
            }
        } else if (this.type.equals(TYPE_GAME_MULTIPLAYER)) {
            team.setBestTimeMultiplayer(roomsObserver.get(0).getTime());
            deselect();
            if (won) {
                txt = "Ganó: Equipo " + team.getTeamName();
            } else {
                txt = "Perdió: Equipo " + team.getTeamName();
            }
        }
        for (int i = 0; i < roomsObserver.size(); i++) {
            roomsObserver.get(i).showMessageWin(txt);
        }
    }

    /**
     *
     */
    public void deselect() {
        if (this.type.equals(GameRoom.TYPE_GAME_SINGLE)) {
            player.setSelected(false);
        } else if (this.type.equals(GameRoom.TYPE_GAME_MULTIPLAYER)) {
            for (int i = 0; i < subteam.size(); i++) {
                subteam.finishPlayerOff();
            }
        }
    }

    /**
     *
     * @param e
     */
    @Override
    public void addObserver(RoomsInterface e) {
        roomsObserver.add(e);
    }

    /**
     *
     * @param index
     * @return
     */
    @Override
    public RoomsInterface removeObserver(int index) {
        return roomsObserver.remove(index);
    }

}
