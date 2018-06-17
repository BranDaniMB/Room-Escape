/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import builderteam.InvalidDataException;
import files.PropertiesConfig;
import gui.rooms.Room1;
import gui.rooms.RoomsInterface;
import java.util.ArrayList;
import java.util.Map.Entry;
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
    private ArrayList<RoomsInterface> roomsObserver;
    private int unlock;
    private String type;
    private Subteam subteam;
    private RoomsInterface room;

    public boolean isSingleGame() {
        return type.equals("single");
    }

    public GameRoom(Game game, Entry<Team, Subteam> entry, RoomRiddle gameRiddle, String type) {
        this.game = game;
        this.padlocks = new ArrayList<>();
        this.team = team;
        this.unlock = 0;
        this.roomsObserver = new ArrayList<>();
        this.type = type;
        this.subteam = subteam;
        this.room = gameRiddle.getRoom();
        loadPadlocks(gameRiddle);
        team.setSelect(false);
    }

    public GameRoom(Game game, Team team, RoomRiddle gameRiddle, String type) {
        this.game = game;
        this.padlocks = new ArrayList<>();
        this.team = team;
        this.unlock = 0;
        this.roomsObserver = new ArrayList<>();
        this.type = type;
        this.subteam = new Subteam();
        this.room = gameRiddle.getRoom();
        loadPadlocks(gameRiddle);
        team.setSelect(false);
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

    public void openWindowsSingle() {
        createWindows();
    }

    private void createWindows() {
        if (room instanceof Room1) {
            Room1 room1 = new Room1(this);
            addObserver(room1);
            room1.setVisible(true);
        }
//        } else if (room instanceof Room2) {
//            Room2 room2 = new Room2(this);
//            addObserver(room2);
//            room3.setVisible(true);
//        } else if (room instanceof Room3) {
//            Room3 room3 = new Room1(this);
//            addObserver(room3);
//            room3.setVisible(true);
//        } else if (room instanceof Room4) {
//            Room4 room4 = new Room4(this);
//            addObserver(room4);
//            room4.setVisible(true);
//        } else if (room instanceof Room5) {
//            Room5 room5 = new Room5(this);
//            addObserver(room5);
//            room1.setVisible(true);
//        } else if (room instanceof Room6) {
//            Room6 room6 = new Room6(this);
//            addObserver(room6);
//            room6.setVisible(true);
//        }
    }

    public void openWindowsMultiplayer(int players) {
        for (int i = 0; i < players; i++) {
            createWindows();
        }
    }

    public void updateInfo(String msj) {
        for (int i = 0; i < roomsObserver.size(); i++) {
            roomsObserver.get(i).update(msj);
        }
    }

    public void updateTracks(int padlock) {
        for (int i = 0; i < roomsObserver.size(); i++) {
            roomsObserver.get(i).unlockTrackLocked(padlock);
        }
    }

    public void updatePadlock(int padlock) {
        for (int i = 0; i < roomsObserver.size(); i++) {
            roomsObserver.get(i).updatePadlock(padlock);
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
        for (int i = 0; i < roomsObserver.size(); i++) {
            roomsObserver.get(i).showMessageWin(txt);
        }
    }

    public void deselectTeam() {
        for (int i = 0; i < subteam.size(); i++) {
            subteam.get(i).setSelected(false);
        }
    }

    @Override
    public void addObserver(RoomsInterface e) {
        roomsObserver.add(e);
    }

    @Override
    public RoomsInterface removeObserver(int index) {
        return roomsObserver.remove(index);
    }

}
