/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import builderteam.InvalidDataException;
import files.PropertiesConfig;
import gui.main.InitMainGUI;
import java.util.ArrayList;
import javafx.application.Application;
import listManager.TeamList;
import objects.Player;
import objects.Team;
import objects.runGameRiddle;

/**
 *
 * @author Jermy
 */
public class Game extends Thread {

    private Chrono chrono;
    private ArrayList<GameRoom> gameRooms;
    private boolean finishGame;

    public synchronized void singularMode() throws InterruptedException {
        while (true) {
            wait();
        }
    }

    public synchronized void selectToPlay(String TeamName, String players) throws InvalidDataException {
        Team aux = null;
        selectTeam(TeamName, aux);
        String[] player = players.split("-");
        if (player.length == 1) {
            throw new InvalidDataException("Debe contener al menos 2 jugadores");
        }
        for (int i = 0; i < player.length; i++) {
            selectPlayer(player[i].toString(), aux);
        }
    }

    private synchronized void selectPlayer(String name, Team team) throws InvalidDataException {
        Player player = team.searchPlayer(name);
        if (player.isSelected()) {
            throw new InvalidDataException("Jugador ya seleccionado\n Eliga diferentes jugadores");
        }
        if ((team.getPlayersOnline() == PropertiesConfig.getInstance().getProperties("maxPlayers")) && !player.isSelected()) {
            throw new InvalidDataException("Ya se encuentran los jugadores completos");
        }
        if (player == null) {
            throw new InvalidDataException("Jugador No existe");
        }
        player.setSelected(true);
        team.setPlayersOnline(team.getPlayersOnline() + 1);
    }

    private synchronized void selectTeam(String name, Team aux) throws InvalidDataException {
        aux = TeamList.getInstance().searchTeam(name);
        if (aux == null) {
            throw new InvalidDataException("Equipo Inexistente");
        }
        if ((TeamList.getInstance().getTeamsPlaying() == PropertiesConfig.getInstance().getProperties("maxTeamsPlaying")) && !aux.isPlaying()) {
            throw new InvalidDataException("Ya se encuentran los equipos completos");
        }
        aux.setPlaying(true);
        TeamList.getInstance().setTeamsPlaying(TeamList.getInstance().getTeamsPlaying() + 1);
    }

    public synchronized void multiplayerMode() throws InterruptedException {
        while (true) {
            wait();
        }

    }

    public void starPlay() {
    }

    public void createGameRoom(Team team, runGameRiddle gameRiddle, int players) {
        GameRoom gameRoom = new GameRoom(this, team, gameRiddle, players);
        gameRooms.add(gameRoom);
        gameRoom.start();
    }

    public Chrono getChrono() {
        return chrono;
    }

    public void setChrono(Chrono chrono) {
        this.chrono = chrono;
    }

    public ArrayList<GameRoom> getGameRooms() {
        return gameRooms;
    }

    public void setGameRooms(ArrayList<GameRoom> gameRooms) {
        this.gameRooms = gameRooms;
    }

    public boolean isFinishGame() {
        return finishGame;
    }

    public void setFinishGame(boolean finishGame) {
        this.finishGame = finishGame;
    }

    @Override
    public void run() {
        Application.launch(InitMainGUI.class, "room1");
    }
}
