/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import builderteam.InvalidDataException;
import files.PropertiesConfig;
import gui.rooms.Room1;
import gui.rooms.RoomInterface;
import java.util.ArrayList;
import objects.Padlock;
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
    private ArrayList<RoomInterface> rooms;
    private int unlock;
    private String type;
    private Subteam subteam;
    private RoomInterface room;

    public boolean isSingleGame() {
        return type.equals("single");
    }

    public GameRoom(Game game, Team team, Subteam subteam, RoomRiddle gameRiddle, String type) {
        this.game = game;
        this.padlocks = new ArrayList<>();
        this.team = team;
        this.unlock = 0;
        this.rooms = new ArrayList<>();
        this.type = type;
        this.subteam = subteam;
        this.room = gameRiddle.getRoomInterface();
        loadPadlocks(gameRiddle);
        team.setSelect(false);
    }

    public GameRoom(Game game, Team team, RoomRiddle gameRiddle, String type) {
        this.game = game;
        this.padlocks = new ArrayList<>();
        this.team = team;
        this.unlock = 0;
        this.rooms = new ArrayList<>();
        this.type = type;
        this.subteam = new Subteam();
        this.room = gameRiddle.getRoomInterface();
        loadPadlocks(gameRiddle);
        team.setSelect(false);
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
            updateInfo(padlocks.get(padlock).getIdPadlock() + " desbloqueado\n");
            updatePadlock(padlock);
            setPadlockText(padlock);
            if (unlock == PropertiesConfig.getInstance().getProperties("padlocksCount")) {
                finishMessage();
            }
        }
    }

    public void tryUnlockTrack(String msj, int padlock) {
        if (padlocks.get(padlock).getRiddle().getTrackLock().tryUnlock((msj.toLowerCase().trim()))) {
            updateInfo(padlocks.get(padlock).getIdPadlock() + " pista desbloqueada\n");
            updateTracks(padlock);
        }
    }

    public String getPadlockQuestion(int padlock) {
        return padlocks.get(padlock).getRiddle().getQuestion();
    }

    public String getLockedTrackQuestion(int padlock) {
        return padlocks.get(padlock).getRiddle().getTrackLock().getQuestion();
    }

    public String getTrackSimple(int padlock, int track) {
        return padlocks.get(padlock).getRiddle().getTracks().get(track);
    }

    public String getUnlockTrack(int padlock) {
        return padlocks.get(padlock).getRiddle().getTrackLock().getTrack();
    }

    private void loadPadlocks(RoomRiddle roomRiddle) {
        for (int i = 0; i < roomRiddle.getListRiddle().size(); i++) {
            padlocks.add(new Padlock(roomRiddle.getListRiddle().get(i), "Candado: " + (i + 1)));
        }
    }

    private void setPadlockText(int padlock) {
        if (padlocks.get(padlock).isOpen()) {
            padlocks.get(padlock).getRiddle().getTrackLock().setTrack(padlocks.get(padlock).getRiddle().getTrackLock().getTrack() + "\n" + padlocks.get(padlock).getIdPadlock());
            for (int j = 0; j < padlocks.get(padlock).getRiddle().getTracks().size(); j++) {
                padlocks.get(padlock).getRiddle().getTracks().set(j, padlocks.get(padlock).getRiddle().getTracks().get(j) + "\n" + padlocks.get(padlock).getIdPadlock());
            }
        }
    }

    public void openWindowSingle() {
    }

    private RoomInterface createWindows() {
        if (room instanceof Room1) {
            Room1 room1 = new Room1(this);
            room1.setVisible(true);
            return room1;
        }
        return null;
    }

    public void openWindowsMultiplayer(int players) {
        for (int i = 0; i < players; i++) {
            if (room instanceof Room1) {
                rooms.add(createWindows());
            }
        }
    }

    @Override
    public void add(RoomInterface e) {
        rooms.add(e);
    }

    @Override
    public RoomInterface remove(int index) {
        return rooms.remove(index);
    }

    public void updateInfo(String msj) {
        for (int i = 0; i < rooms.size(); i++) {
            rooms.get(i).update(msj);
        }
    }

    public void updateTracks(int padlock) {
        for (int i = 0; i < rooms.size(); i++) {
            rooms.get(i).unlockTrackLocked(padlock);
        }
    }

    public void updatePadlock(int padlock) {
        for (int i = 0; i < rooms.size(); i++) {
            rooms.get(i).updatePadlock(padlock);
        }
    }

    public void finishMessage() {
        String txt = "";
        if (!game.isFinishGame()) {
            game.setFinishGame(true);
            txt = "Ganó";
        } else {
            txt = "Perdió";
        }
        for (int i = 0; i < rooms.size(); i++) {
            rooms.get(i).showMessageWin(txt);
        }
    }

    public void deselectTeam() {
        for (int i = 0; i < subteam.size(); i++) {
            subteam.get(i).setSelected(false);
        }
    }
}
